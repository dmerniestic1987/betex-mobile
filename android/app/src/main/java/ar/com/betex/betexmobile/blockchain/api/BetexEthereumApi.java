package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;
import android.util.Log;

import org.web3j.crypto.Credentials;

import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

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
    protected Credentials credentials;
    protected BetexWallet wallet;
    protected ContractGasProvider contractGasProvider = new DefaultGasProvider();
    protected Context context;

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
        this.configuration = configuration;
        this.web3j = BetexWeb3jUtils.buildEthereumConnection(this.configuration);
        this.wallet = FileBetexWallet.getInstance(context);
        this.credentials = this.wallet.getCredentials();
        this.context = context;
    }


    /**
     * Obtiene la versión
     * @return version
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
