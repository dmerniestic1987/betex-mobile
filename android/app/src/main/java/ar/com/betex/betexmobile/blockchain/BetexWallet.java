package ar.com.betex.betexmobile.blockchain;

import android.util.Log;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.com.betex.betexmobile.entities.WalletBean;

public class BetexWallet {
    private static final String TAG = "BetexWallet";
    private static final BetexWallet INSTANCE = new BetexWallet();
    private static final String BETEX_WALLET_FILE_NAME="betexWallet.adt";
    private static Credentials credentials;
    private static List<WalletBean> listWallets;
    private String currentName;
    private List<String> names;
    private List<String> passwords;
    private List<String> filepaths;
    private List<String> addresses;

    private BetexWallet() {
        super();
        listWallets =new ArrayList<>();
        currentName = "";
        names = new ArrayList<>();
        passwords = new ArrayList<>();
        filepaths = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    public String getCurrentName() {
        return currentName;
    }
    public List getNames(){
        return names;
    }
    public List getPasswords(){
        return passwords;
    }
    public List getFilepaths(){
        return filepaths;
    }
    public List getAddresses(){
        return addresses;
    }

    /**
     * Obtiene una lista de las wallets
     * @param filepath
     * @return
     */
    public List<WalletBean>  getListWallets(String filepath) {
        File fullPathWallet = new File(filepath+"/"+BETEX_WALLET_FILE_NAME);
        if (fullPathWallet.exists()){
            List<WalletBean> temp_lists = readWalletFile(filepath);
            listWallets.clear();
            listWallets.addAll(temp_lists);

            for (WalletBean walletBean: listWallets){
                String tn = walletBean.getName();
                if (!names.contains(tn)) {

                    String tp = walletBean.getPassword();
                    String tf = walletBean.getPath();
                    String ad = walletBean.getAddress();
                    names.add(tn);
                    passwords.add(tp);
                    filepaths.add(tf);
                    addresses.add(ad);
                }
            }
        }
        return listWallets;
    }

    /**
     * @param name      current name of wallet
     * @param password  password user once set
     * @param filename  including filepath+filename!!!!
     */
    public void useWallet(String name,String password, String filename){
        try {
            if (!filename.equals("")) {
                currentName = name;
                credentials = WalletUtils.loadCredentials(password, filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
    }

    public void importWallet(String name,String password,String privateKey,String filepath){
        String pk = "";
        WalletBean walletBean = new WalletBean();
        if (privateKey.equals("")){
            pk = "65e080f727d9ddca08bff41f57283fc7d5e032bb5af8de963dade6a6caaa1ec4";
        }else {
            pk = privateKey;
        }
        ECKeyPair ecKeyPair = ECKeyPair.create(new BigInteger(pk,16));
        String pri = Numeric.toHexStringWithPrefix(ecKeyPair.getPrivateKey());
        credentials = Credentials.create(ecKeyPair);

        String address = credentials.getAddress();
        try {
            String filename = WalletUtils.generateWalletFile(password,ecKeyPair,new File(filepath),false);
            String file=filepath+"/"+filename;
            File f = new File(filepath+"/walletBean.adt");
            if (f.exists()){
                listWallets = readWalletFile(filepath);
            }

            //namelists.add(name);
            walletBean.setName(name);
            walletBean.setPassword(password);
            walletBean.setAddress(address);
            walletBean.setPath(file);
            listWallets.add(walletBean);
            saveWalletFile(filepath);
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void createWallet(String name,String password,String filepath){
        try {
            WalletBean walletBean = new WalletBean();
            String filename = WalletUtils.generateLightNewWalletFile(password,new File(filepath));
            String file=filepath+"/"+filename;
            credentials = WalletUtils.loadCredentials(password,filepath+"/"+filename);
            String address = credentials.getAddress();
            ECKeyPair ecKeyPair = credentials.getEcKeyPair();
            String pri = Numeric.toHexStringWithPrefix(ecKeyPair.getPrivateKey());
            String pub = Numeric.toHexStringWithPrefix(ecKeyPair.getPublicKey());
            //File file1 = new File("walletBean.adt");
            File f = new File(filepath+"/walletBean.adt");
            if (f.exists()){
                listWallets = readWalletFile(filepath);
            }

            walletBean.setName(name);
            walletBean.setPassword(password);
            walletBean.setAddress(address);
            walletBean.setPath(file);
            listWallets.add(walletBean);
            saveWalletFile(filepath);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Serializa una lista de wallets
     * @param filepath
     * @throws IOException
     */
    private static void saveWalletFile(String filepath) throws IOException {
        File walletFile = new File(filepath + BETEX_WALLET_FILE_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(walletFile);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        WalletBean[] arrayWalletBean = new WalletBean[listWallets.size()];
        listWallets.toArray(arrayWalletBean);
        out.writeObject(arrayWalletBean);
        out.close();
    }

    /**
     * Lee el archivo de wallets y las deserializa en una lista de WalletBean
     * @param filepath List<WalletBean>
     * @return listWallets
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<WalletBean> readWalletFile(String filepath) {
        List<WalletBean> listWallets;
        try {
            File walletFile = new File(filepath + BETEX_WALLET_FILE_NAME);
            FileInputStream fileInputStream = new FileInputStream(walletFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            WalletBean[] walletBean = (WalletBean[]) objectInputStream.readObject();
            listWallets = new ArrayList<>(Arrays.asList(walletBean));
        } catch (Exception e){
            Log.e(TAG, "error leyendo wallet", e);
            listWallets = new ArrayList<>();
        }
        return listWallets;
    }
}
