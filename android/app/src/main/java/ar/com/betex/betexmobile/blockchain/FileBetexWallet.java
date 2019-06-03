package ar.com.betex.betexmobile.blockchain;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.io.IOException;

import ar.com.betex.betexmobile.Exception.BetexWalletException;
import ar.com.betex.betexmobile.entities.WalletBean;

/**
 * Permite gestionar las operaciones para cargar y crear wallets para realizar
 * transacciones sobre la blockchain de Ethereum.
 * @author Diego Mernies
 */
public class FileBetexWallet implements BetexWallet{

    private static final String TAG = "FileBetexWallet";
    private static final String BETEX_WALLET_FILE_NAME="betexWallet.json";
    private static final String KEYSTORE_FOLDER = "keystore";

    private static Credentials credentials = null;
    private static WalletBean walletBean = null;
    private static FileBetexWallet instance = null;
    private Context context;

    private FileBetexWallet(Context context) {
        super();
        this.context = context;
    }

    /**
     * Obtiene una instancia de la wallet
     * @param contexto
     * @return
     */
    public static FileBetexWallet getInstance(Context contexto){
        if (instance == null)
            instance = new FileBetexWallet(contexto);

        return instance;
    }
/*
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
            walletBean.setBetexName(name);
            walletBean.setSha256BetexPassword(password);
            walletBean.setAddress(address);
            walletBean.setWeb3jWalletFilePath(file);
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
    */


    @Override
    public boolean isWalletCreated() {
        File keyStoreDir = new File(keyStoreDirPath());
        if (!keyStoreDir.exists()){
            return false;
        }

        File betexWallet = new File(keyStoreDirPath() + "/" + BETEX_WALLET_FILE_NAME);
        return betexWallet.exists();
    }

    @Override
    public boolean loadWallet(String betexPassword) throws BetexWalletException {
        Log.i(TAG, "Loading Wallet");
        //Verifica que clave != null
        if (betexPassword == null){
            BetexWalletException bex = new BetexWalletException("Betex Password no pude ser null");
            bex.setCode("loading_betex_wallet_file");
            bex.setOperation("Reading Wallet with null betexPassword");
            throw bex;
        }

        //Cargar el archivo de la wallet
        File betexWallet = new File(keyStoreDirPath() + "/" + BETEX_WALLET_FILE_NAME);
        if (!betexWallet.exists()){
            return false;
        }

        WalletBean tempWallet = this.readBetexWalletFile(betexWallet);
        String betexPasswordSha256 = new String(Hex.encodeHex(DigestUtils.sha256(betexPassword)));
        if(!tempWallet.getSha256BetexPassword().equals(betexPasswordSha256)){
            BetexWalletException bex = new BetexWalletException("Betex Password incorrecto");
            bex.setCode("loading_betex_wallet_file");
            bex.setOperation("Incorrect Betex credentials");
            throw bex;
        }

        readWeb3jWalletCredentials(betexPassword, tempWallet.getWeb3jWalletFilePath());

        walletBean = tempWallet;
        return true;
    }

    @Override
    public void createWallet(String betexWalletName, String betexPassword) throws BetexWalletException {
        Log.i(TAG, "Creating Wallet");

        //Primero creamos el archivo
        String web3jWalletFileName = null;
        boolean okCreation = true;
        try {
            File keyStorDir = new File(this.keyStoreDirPath());
            if (!keyStorDir.exists()){
                keyStorDir.mkdir();
            }
            web3jWalletFileName = WalletUtils.generateLightNewWalletFile(betexPassword,new File(keyStoreDirPath()));
        } catch (Exception e) {
            BetexWalletException bex = new BetexWalletException("Error creating web3j wallet", e);
            bex.setCode("creating_betex_wallet_file");
            bex.setOperation("Creating a new web3j wallet");
            throw bex;
        }

        //Ahora leemos el archivo para cargar las nuevas credenciales generadas
        readWeb3jWalletCredentials(betexPassword, web3jWalletFileName);

        walletBean = new WalletBean();
        walletBean.setBetexName(betexWalletName);
        String betexPasswordSha256 = new String(Hex.encodeHex(DigestUtils.sha256(betexPassword)));
        walletBean.setSha256BetexPassword(betexPasswordSha256);
        walletBean.setAddress(credentials.getAddress());
        walletBean.setWeb3jWalletFilePath(web3jWalletFileName);

        writeBetexWalletFile(walletBean);
    }

    @Override
    public void importWallet(String newBetexWalleName, String betexPassword, String walletPrivateKey) throws BetexWalletException {

    }

    @Override
    public void importWalletWithMnemotecnic(String newBetexWalleName, String betexPassword, String mnemotecnic) throws BetexWalletException {

    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Obtiene el path del directorio keyStore donde se guarda el archivo de la Key
     * @return Full Path keyStore
     */
    private String keyStoreDirPath(){
        return context.getFilesDir()+ "/" + KEYSTORE_FOLDER;
    }

    /**
     * Lee el archivo Betex File
     * @param betexWallet
     * @return walletBean
     * @throws BetexWalletException
     */
    private WalletBean readBetexWalletFile(File betexWallet) throws BetexWalletException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WalletBean walletBean = objectMapper.readValue(betexWallet, WalletBean.class);
            return walletBean;
        } catch (IOException e) {
            BetexWalletException bex = new BetexWalletException("Error reading Betex Wallet File", e);
            bex.setCode("reading_betex_wallet_file");
            bex.setOperation("Reading JSON file in KeyStore");
            throw bex;
        }

    }

    /**
     * Graba un archivo que representa a la wallet de Betex
     * @param walletBean
     * @throws BetexWalletException
     */
    private void writeBetexWalletFile(WalletBean walletBean) throws BetexWalletException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File betexFile = new File(keyStoreDirPath() + "/" + BETEX_WALLET_FILE_NAME);
            objectMapper.writeValue(betexFile, walletBean);

        } catch (IOException e) {
            BetexWalletException bex = new BetexWalletException("Error writing Betex Wallet File", e);
            bex.setCode("writing_betex_wallet_file");
            bex.setOperation("Writing JSON file in KeyStore");
            throw bex;
        }
    }

    /**
     * Carga las credenciales de la wallet
     * @param betexPassword
     * @param web3jWalletFileName
     * @throws BetexWalletException
     */
    private void readWeb3jWalletCredentials(String betexPassword, String web3jWalletFileName) throws BetexWalletException{
        try {
            credentials = WalletUtils.loadCredentials(betexPassword,keyStoreDirPath() + "/" + web3jWalletFileName);
        } catch (Exception e) {
            BetexWalletException bex = new BetexWalletException("Error creating web3j wallet", e);
            bex.setCode("creating_betex_wallet_file");
            bex.setOperation("Loading the new web3j wallet");
            throw bex;
        }
    }
}
