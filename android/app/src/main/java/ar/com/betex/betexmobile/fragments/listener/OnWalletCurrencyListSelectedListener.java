package ar.com.betex.betexmobile.fragments.listener;

import ar.com.betex.betexmobile.blockchain.entities.CryptoAsset;

/**
 * Listener para detectar la lista de las critpomonedas
 */
public interface OnWalletCurrencyListSelectedListener {

    void onCurrencySelected(CryptoAsset currency);
}
