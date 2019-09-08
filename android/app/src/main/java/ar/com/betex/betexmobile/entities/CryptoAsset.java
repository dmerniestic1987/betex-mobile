package ar.com.betex.betexmobile.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Representa un criptoactivo. Por el momento solo están disponbiles ETH y BTX
 */
public class CryptoAsset implements Serializable {
    private String symbol;
    private BigInteger balance;
    private String currencyName;
    private BigDecimal valueInUsd;
    private int imgId;
    private boolean isToken;

    public CryptoAsset(){
        super();
        this.isToken = false;
    }

    public static CryptoAsset getEtherInstance(){
        CryptoAsset asset = new CryptoAsset();
        asset.setSymbol("ETH");
        asset.setCurrencyName("Ether");
        return asset;
    }

    public static CryptoAsset getBtxInstance(){
        CryptoAsset asset = new CryptoAsset();
        asset.setSymbol("BTX");
        asset.setCurrencyName("Betex");
        return asset;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getValueInUsd() {
        return valueInUsd;
    }

    public void setValueInUsd(BigDecimal valueInUsd) {
        this.valueInUsd = valueInUsd;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public boolean isToken() {
        return isToken;
    }

    public void setToken(boolean token) {
        isToken = token;
    }
}
