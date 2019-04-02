package ar.com.betex.betexmobile.fragments.listener;

import ar.com.betex.betexmobile.beans.Bet;

/**
 *
 */
public interface OnP2PBetFragmentInteractionListener {
    /**
     * El usuario acepta una apuesta
     * @param bet
     */
    void onP2PBetAccepted(Bet bet);

    /**
     * El usuario crea una nueva apuesta del tipo P2P (Challenge)
     * @param bet
     */
    void onP2PBetCreated(Bet bet);
}