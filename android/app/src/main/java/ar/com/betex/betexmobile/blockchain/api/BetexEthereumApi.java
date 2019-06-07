package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;
import android.util.Log;

import org.web3j.crypto.Credentials;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.util.concurrent.ExecutionException;

import ar.com.betex.betexmobile.blockchain.utils.BetexWeb3jUtils;
import ar.com.betex.betexmobile.blockchain.wallet.BetexWallet;
import ar.com.betex.betexmobile.blockchain.wallet.FileBetexWallet;
import ar.com.betex.betexmobile.entities.Configuration;

/**
 * Provee la interfaz para comunicarse con los smart contracts de Betex Gondwana.
 * @author Diego Alejandro Mernies
 */
public class BetexEthereumApi {
    protected Web3j web3j;
    protected Configuration configuration;
    protected Credentials credential;
    protected BetexWallet wallet;

    public BetexEthereumApi(Context context){
        super();
        this.init(context, new Configuration());
    }

    public BetexEthereumApi(Context context, Configuration configuration){
        super();
        this.init(context, configuration);
    }
    /**
     * Inicializar la API para comunicarse, incluyendo la carga de las credenciales
     * @param context - Contexto
     * @param configuration - Parámetros de configuración
     */
    public void init(Context context, Configuration configuration){
        this.web3j = BetexWeb3jUtils.buildEthereumConnection(this.configuration);
        this.wallet = FileBetexWallet.getInstance(context);
        this.credential = this.wallet.getCredentials();
    }

    /**
     * Obtiene la versión
     * @return
     */
    public String getClientVersion(){
        String version = "UNKNOWN";

        try {
            version = BetexWeb3jUtils.getClientVersion(this.web3j);
        } catch (Exception e) {
            Log.e("BetexEthereumApi", "No se pudo cargar la verisón", e);
        }

        return version;
    }
}
