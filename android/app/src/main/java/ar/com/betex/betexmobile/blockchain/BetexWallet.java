package ar.com.betex.betexmobile.blockchain;

import org.web3j.crypto.Credentials;

import ar.com.betex.betexmobile.Exception.BetexWalletException;

/**
 * Permite gestionar la wallet de la aplicación que permitirá realizar
 * transacciones en la blockchain.
 * @author Diego Mernies
 */
public interface BetexWallet {
    /**
     * Verifica si la Wallet Existe.
     * @return true si la wallet existe, false de lo contrario
     */
    boolean isWalletCreated();

    /**
     * Carga una wallet dada la clave de Betex Wallet, que permite desbloquear el archivo
     * que utiliza web3 para firmar las transacciones. Para cargar la wallet compara los
     * archivos sha256
     * @param betexPassword
     * @return true si se cargó la wallet, false de lo contrario
     * @throws BetexWalletException
     */
    boolean loadWallet(String betexPassword) throws BetexWalletException;

    /**
     * Crea una nueva wallet
     * @param betexWalletName
     * @param betexPassword
     * @throws BetexWalletException
     */
    void createWallet(String betexWalletName, String betexPassword) throws BetexWalletException;

    /**
     * Importa una wallet existente para poder utilizarlo en el sistema
     * @param newBetexWalleName
     * @param betexPassword
     * @param walletPrivateKey
     * @throws BetexWalletException
     */
    void importWallet(String newBetexWalleName, String betexPassword, String walletPrivateKey) throws BetexWalletException;

    /**
     * Importa una wallet existente utilizando un mnemotecnicas de 12 palabras
     * @param newBetexWalleName Nombre de la wallet
     * @param betexPassword Clave plana para debloquear Betex
     * @param mnemotecnic de 12 palabras
     * @throws BetexWalletException
     */
    void importWalletWithMnemotecnic(String newBetexWalleName, String betexPassword, String mnemotecnic) throws BetexWalletException;

    /**
     * Obtiene las credenciales para operar con web3
     * @return credenciales
     */
    Credentials getCredentials();
}
