package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.response.Callback;
import org.web3j.tx.response.QueuingTransactionReceiptProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;


import ar.com.betex.betexmobile.blockchain.utils.BetexWeb3jUtils;
import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.betexmobile.exception.BetexException;
import ar.com.betex.blockchain.sc.BetexMobileGondwana;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Permite comunicarse con el contrato de Betex Gondwana. Siempre se verifica que el bityecode
 * del ABI concuerde con el deployado en la Blockchain para evitar una incorrecta invocación.
 * @author Diego Mernies
 */
public class BetexMobileGondwanaApi extends BetexEthereumApi {
    private static BetexMobileGondwana betexMobileGondwana;

    public BetexMobileGondwanaApi(Context context, Configuration configuration){
        super(context, configuration);
    }

    /**
     * Carga el contrato inteligente
     * @throws BetexException
     */
    public void load() {
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        betexMobileGondwana = BetexMobileGondwana.load(configuration.getBetexMobileContractAddress(), web3j, credentials, contractGasProvider);
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

    /**
     * Coloca una apuesta con BTX
     * @param marketRunnerHash
     * @param odd
     * @param stake
     * @param isBack
     * @return flowable
     */
    public Flowable<TransactionReceipt> placeMarketBetBtx( String marketRunnerHash
                                                         , BigDecimal odd
                                                         , BigDecimal stake
                                                         , Boolean isBack ){
        byte[] bytes = Numeric.hexStringToByteArray(marketRunnerHash);

        return betexMobileGondwana.placeMarketBetBtx( bytes
                , BetexWeb3jUtils.toTokenPrecision(odd)
                , BetexWeb3jUtils.toTokenPrecision(stake)
                , isBack).flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<TransactionReceipt> placeMarketBetWei(String marketRunnerHash
            , BigDecimal odd
            , BigDecimal stake
            , Boolean isBack){

        BigInteger bdWeiValue =  BetexWeb3jUtils.toTokenPrecision(odd).multiply(BetexWeb3jUtils.toTokenPrecision(stake));
        if (!isBack){
            bdWeiValue = BetexWeb3jUtils.toTokenPrecision(odd.min(BigDecimal.ONE)).multiply(BetexWeb3jUtils.toTokenPrecision(stake));
        }
        byte[] bytes = Numeric.hexStringToByteArray(marketRunnerHash);

        return betexMobileGondwana.placeMarketBetWei( bytes
                , BetexWeb3jUtils.toTokenPrecision(odd)
                , BetexWeb3jUtils.toTokenPrecision(stake)
                , isBack
                , bdWeiValue).flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
