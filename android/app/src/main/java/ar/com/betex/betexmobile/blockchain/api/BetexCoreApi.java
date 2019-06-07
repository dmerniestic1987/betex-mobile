package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import ar.com.betex.betexmobile.blockchain.sc.BetexCore;
import ar.com.betex.betexmobile.entities.Configuration;

/**
 * Permite comunicarse con el contrato de Betex Core
 * @author Diego Mernies
 */
public class BetexCoreApi extends BetexEthereumApi {
    private static BetexCore betexCore;

    public BetexCoreApi(Context context){
        super(context);
    }

    public BetexCoreApi(Context context, Configuration configuration){
        super(context, configuration);
    }

    public void load(){
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        betexCore = BetexCore.load(configuration.getBetexCoreContractAddress(), web3j, credential, contractGasProvider);
    }

    public String helloWorld(){

        try {
            return betexCore.getMensajeHola().sendAsync().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "HELLO WORLD";
    }

    public void openMarket(){
        try {
            TransactionReceipt receipt = betexCore.openMarket(new BigInteger(String.valueOf(System.currentTimeMillis()))).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
