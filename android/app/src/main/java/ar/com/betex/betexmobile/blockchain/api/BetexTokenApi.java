package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.blockchain.sc.BetexCore;
import ar.com.betex.blockchain.sc.BetexToken;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Permite comunicarse con el contrato de Betex Token
 * @author Diego Mernies
 */
public class BetexTokenApi extends BetexEthereumApi {
    private static BetexToken betexToken;

    public BetexTokenApi(Context context, Configuration configuration){
        super(context, configuration);
    }

    public void load(){
        betexToken = BetexToken.load(configuration.getBetexTokenContractAddress(), web3j, credential, contractGasProvider);
    }

    /**
     * Obtiene el balance de los BTX de una wallet determinada
     * @param address
     * @return flowable
     */
    public Flowable<BigInteger> balanceOf(String address){
        return betexToken.balanceOf(address).flowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    /**
     * Obtiene el balance en BTX de la wallet de la aplicación
     * @return flowable
     */
    public Flowable<BigInteger> myBalance(){
        return this.balanceOf(wallet.getAddress());
    }
}
