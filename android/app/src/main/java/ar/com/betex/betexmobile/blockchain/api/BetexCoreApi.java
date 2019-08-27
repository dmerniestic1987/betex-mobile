package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;


import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.blockchain.sc.BetexMobileGondwana;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Permite comunicarse con el contrato de Betex Core
 * @author Diego Mernies
 */
public class BetexCoreApi extends BetexEthereumApi {
    private static BetexMobileGondwana betexMobileGondwana;

    public BetexCoreApi(Context context, Configuration configuration){
        super(context, configuration);
    }

    public void load(){
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        betexMobileGondwana = BetexMobileGondwana.load(configuration.getBetexMobileContractAddress(), web3j, credential, contractGasProvider);
    }

    public Flowable<BigInteger> getCommisionCancelBetBtx(){
        return betexMobileGondwana.getComissionCancelBetBtx().flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<TransactionReceipt> cancelMarketBet(BigInteger marketId){
        return betexMobileGondwana.cancelMarketBet(marketId).flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
