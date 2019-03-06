package ar.com.betex.betexmobile.fragments.listener;

public interface OnPlaceBetFragmentListener {
    /**
     * Colocal una apuesta a Favor
     * @return true si fue correctamente colocada, false de lo contrario
     */
    boolean placedBackBet();

    /**
     * Colocal una apuesta En contra
     * @return true si fue correctamente colocada, false de lo contrario
     */
    boolean placedLayBet();

    /**
     * El usuario se arrepiente de colocar la apuesta
     * @return true si fue correctamente colocada, false de lo contrario
     */
    boolean cancelPlaceBet();
}
