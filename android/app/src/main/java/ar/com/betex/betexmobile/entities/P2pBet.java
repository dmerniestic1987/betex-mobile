package ar.com.betex.betexmobile.entities;

import java.math.BigInteger;

/**
 * Representa a los datos de una apuesta P2P
 * @author Diego Mernies
 */
public class P2pBet extends Bet{
    private String creatorUser;
    private BigInteger amount;
    /**
     * Es el nombre de usuario o address del usuario creador. En principio será la dirección pública
     * de la wallet
     * @return creatorUser
     */
    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
