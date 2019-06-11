package ar.com.betex.betexmobile.blockchain.wallet;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ar.com.betex.betexmobile.blockchain.entities.CryptoAsset;
import ar.com.betex.betexmobile.exception.BetexException;
import ar.com.betex.betexmobile.blockchain.entities.WalletBean;

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

    public String getAddress(){
        if (credentials != null){
            return credentials.getAddress();
        }

        else{
            return "0x000";
        }
    }

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
    public boolean loadWallet(String betexPassword) throws BetexException {
        Log.i(TAG, "Loading Wallet");
        //Verifica que clave != null
        if (betexPassword == null){
            BetexException bex = new BetexException("Betex Password no pude ser null");
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
            BetexException bex = new BetexException("Betex Password incorrecto");
            bex.setCode("loading_betex_wallet_file");
            bex.setOperation("Incorrect Betex credentials");
            throw bex;
        }

        readWeb3jWalletCredentials(betexPassword, tempWallet.getWeb3jWalletFilePath());

        walletBean = tempWallet;
        return true;
    }

    @Override
    public void createWallet(String betexWalletName, String betexPassword) throws BetexException {
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
            BetexException bex = new BetexException("Error creating web3j wallet", e);
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
        Log.i("WALLETBEAN", "****ADRESS: " + credentials.getAddress());
        writeBetexWalletFile(walletBean);
    }

    @Override
    public void importWallet(String newBetexWalleName, String betexPassword, String walletPrivateKey) throws BetexException {

    }

    @Override
    public void importWalletWithMnemotecnic(String newBetexWalleName, String betexPassword, String mnemotecnic) throws BetexException {

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
     * @throws BetexException
     */
    private WalletBean readBetexWalletFile(File betexWallet) throws BetexException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WalletBean walletBean = objectMapper.readValue(betexWallet, WalletBean.class);
            return walletBean;
        } catch (IOException e) {
            BetexException bex = new BetexException("Error reading Betex Wallet File", e);
            bex.setCode("reading_betex_wallet_file");
            bex.setOperation("Reading JSON file in KeyStore");
            throw bex;
        }

    }

    /**
     * Graba un archivo que representa a la wallet de Betex
     * @param walletBean
     * @throws BetexException
     */
    private void writeBetexWalletFile(WalletBean walletBean) throws BetexException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File betexFile = new File(keyStoreDirPath() + "/" + BETEX_WALLET_FILE_NAME);
            objectMapper.writeValue(betexFile, walletBean);

        } catch (IOException e) {
            BetexException bex = new BetexException("Error writing Betex Wallet File", e);
            bex.setCode("writing_betex_wallet_file");
            bex.setOperation("Writing JSON file in KeyStore");
            throw bex;
        }
    }

    /**
     * Carga las credenciales de la wallet
     * @param betexPassword
     * @param web3jWalletFileName
     * @throws BetexException
     */
    private void readWeb3jWalletCredentials(String betexPassword, String web3jWalletFileName) throws BetexException {
        try {
            credentials = WalletUtils.loadCredentials(betexPassword,keyStoreDirPath() + "/" + web3jWalletFileName);
        } catch (Exception e) {
            BetexException bex = new BetexException("Error creating web3j wallet", e);
            bex.setCode("creating_betex_wallet_file");
            bex.setOperation("Loading the new web3j wallet");
            throw bex;
        }
    }
}
