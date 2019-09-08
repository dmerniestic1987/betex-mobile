package ar.com.betex.betexmobile.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Contiene la información básica de una apuesta en Betex
 */
public class Bet implements Serializable {
    private BigInteger betId;
    private String marketRunnerHash;
    private Market market;
    private CryptoAsset cryptoAsset;


    public BigInteger getBetId() {
        return betId;
    }

    public void setBetId(BigInteger betId) {
        this.betId = betId;
    }

    public String getMarketRunnerHash() {
        return marketRunnerHash;
    }

    public void setMarketRunnerHash(String marketRunnerHash) {
        this.marketRunnerHash = marketRunnerHash;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public CryptoAsset getCryptoAsset() {
        return cryptoAsset;
    }

    public void setCryptoAsset(CryptoAsset cryptoAsset) {
        this.cryptoAsset = cryptoAsset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Objects.equals(betId, bet.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId);
    }
}
