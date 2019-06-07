package ar.com.betex.betexmobile.fragments.listener;

import ar.com.betex.betexmobile.entities.Bet;

public interface OnMyBetSelectedListener {

    /**
     * Selecciona una apuesta determinada de la lista para mostrar su detalle
     * @param bet
     */
    void onSelectedBetFromList(Bet bet);

    /**
     * Cancela una apuesta particular siempre en cuando no haya matcheado
     * @param bet
     */
    void onCancelSelectedBet(Bet bet);
}
