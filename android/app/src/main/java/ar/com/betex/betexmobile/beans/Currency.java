package ar.com.betex.betexmobile.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Currency implements Serializable {
    private String symbol;
    private BigDecimal balance;
    private String currencyName;
    private BigDecimal valueInUsd;
    private int imgId;

    public Currency(String symbol, BigDecimal balance, String currencyName, BigDecimal valueInUsd, int imgId) {
        this.symbol = symbol;
        this.balance = balance;
        this.currencyName = currencyName;
        this.valueInUsd = valueInUsd;
        this.imgId = imgId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
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
}
