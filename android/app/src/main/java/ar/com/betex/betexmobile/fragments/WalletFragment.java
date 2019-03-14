package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Currency;
import ar.com.betex.betexmobile.util.BetexUtils;
import ar.com.betex.betexmobile.util.DevelopUtils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link WalletFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WalletFragment extends Fragment {
    public static String TAG = "WalletFragment";

    public WalletFragment() {
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BetexUtils.CURRENT_FRAGMENT_SELECTED_BY_USER, TAG);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment WalletFragment.
     */
    // TODO: Rename and change types and number of parameters
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
            FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
            CurrencyFragmentListFragment fragment = CurrencyFragmentListFragment.newInstance(DevelopUtils.hardcodeCryptoCurrencies());
            transaction.replace(R.id.walletContent, fragment, CurrencyFragmentListFragment.TAG);
            transaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    public void drawCurrencyFragment(Currency currency){
        CurrencyFragment fragment = CurrencyFragment.newInstance(currency);
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        transaction.replace(R.id.walletContent, fragment, CurrencyFragmentListFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
