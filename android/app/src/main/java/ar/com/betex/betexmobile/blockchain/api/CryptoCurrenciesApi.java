package ar.com.betex.betexmobile.blockchain.api;

import android.content.Context;
import android.util.Log;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.entities.CryptoAsset;
import ar.com.betex.betexmobile.blockchain.utils.BetexWeb3jUtils;
import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.betexmobile.exception.BetexException;
import ar.com.betex.blockchain.sc.BetexToken;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Permite comunicarse con el contrato de Betex Token
 * @author Diego Mernies
 */
public class CryptoCurrenciesApi extends BetexEthereumApi {
    private static String TAG = "CryptoCurrenciesApi";
    private static BetexToken betexToken;

    public CryptoCurrenciesApi(Context context, Configuration configuration){
        super(context, configuration);
        load();
    }

    /**
     * Se carga el ABI para comunicarse con el contrato
     */
    public void load(){
        betexToken = BetexToken.load( configuration.getBetexTokenContractAddress()
                                    , web3j
                                    , credential
                                    , contractGasProvider );
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
     * Obtiene la lista de las criptomonedas del usuario y el saldo de cada uno de ellos.
     * @return myTickers
     * @throws BetexException
     */
    public List<CryptoAsset> getMyCurrenciesBalance() {
        List<CryptoAsset> myAssets = new ArrayList<>();
        CryptoAsset crypto = new CryptoAsset();
        crypto.setCurrencyName(context.getResources().getString(R.string.ether_cryptocurrency_name_default));
        crypto.setSymbol(context.getResources().getString(R.string.ether_cryptocurrency_symbol_default));

        try {
            BigInteger balanceInWei = BetexWeb3jUtils.getBalanceWei(web3j, wallet.getAddress());
            crypto.setBalance(balanceInWei);

        } catch (Exception e) {
            Log.e(TAG, "No se pudo obtener balance en Eth", e);
            crypto.setBalance(BigInteger.ZERO);
        }
        crypto.setValueInUsd(BigDecimal.ZERO);
        crypto.setImgId(R.drawable.eth);
        myAssets.add(crypto);


        CryptoAsset betex = new CryptoAsset();
        betex.setToken(true);
        betex.setCurrencyName(context.getResources().getString(R.string.betex_cryptocurrency_name_default));
        betex.setSymbol("BTX");
        try {
            BigInteger balanceInBetex = betexToken.balanceOf(wallet.getAddress()).sendAsync().get();
            betex.setBalance(balanceInBetex);
        }
        catch (Exception e) {
            Log.e(TAG, "No se pudo obtener balance en BTX", e);
            betex.setBalance(BigInteger.ZERO);
        }
        betex.setImgId(R.drawable.btx);
        betex.setValueInUsd(BigDecimal.ZERO);
        myAssets.add(betex);

        return myAssets;
    }
}
