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
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    public Flowable<String> helloWorld(){
        return betexCore.getMensajeHola().flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<TransactionReceipt> openMarket(){
        BigInteger marketId = new BigInteger(String.valueOf(System.currentTimeMillis()));
        return betexCore.openMarket(marketId).flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
