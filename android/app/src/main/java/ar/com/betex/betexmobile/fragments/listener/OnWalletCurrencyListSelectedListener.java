package ar.com.betex.betexmobile.fragments.listener;

import ar.com.betex.betexmobile.entities.Currency;

/**
 * Listener para detectar la lista de las critpomonedas
 */
public interface OnWalletCurrencyListSelectedListener {

    void onCurrencySelected(Currency currency);
}
