package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.entities.Currency;
import ar.com.betex.betexmobile.util.BetexUtils;
import ar.com.betex.betexmobile.util.DevelopUtils;

/**
 * Pantalla para gestionar los recursos disponibles en la wallet
 * @author Diego Alejandro Mernies
 */
public class WalletFragment extends BetexFragment {
    public static String TAG = "WalletFragment";

    public WalletFragment() {
        super();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BetexUtils.CURRENT_FRAGMENT_SELECTED_BY_USER, TAG);
    }

    /**
     * Crea una nueva instancia del fragmento
     * @return A new instance of fragment WalletFragment.
     */
    public static WalletFragment newInstance() {
        WalletFragment fragment = new WalletFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            CurrencyFragmentListFragment fragment = CurrencyFragmentListFragment.newInstance(DevelopUtils.hardcodeCryptoCurrencies());
            replaceFragment(fragment, CurrencyFragmentListFragment.TAG, null, R.id.walletContent);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    public void drawCurrencyFragment(Currency currency){
        CurrencyFragment fragment = CurrencyFragment.newInstance(currency);
        replaceFragment(fragment, CurrencyFragmentListFragment.TAG, null, R.id.walletContent);
    }
}
