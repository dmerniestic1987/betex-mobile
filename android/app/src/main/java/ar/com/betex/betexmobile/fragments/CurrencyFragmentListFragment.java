package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.CurrencyFragmentListRecyclerViewAdapter;
import ar.com.betex.betexmobile.blockchain.api.CryptoCurrenciesApi;
import ar.com.betex.betexmobile.entities.ConfigurationRinkeby;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;

/**
 * La lista de tokens y Eth para que el usuario pueda consultar
 * @author  Diego Mernies
 */
public class CurrencyFragmentListFragment extends Fragment {
    public static final String TAG = "CurrencyFragmentListFragment";
    private OnWalletCurrencyListSelectedListener mListener;
    private RecyclerView recyclerView;
    private CryptoCurrenciesApi cryptoCurrenciesApi;
    public CurrencyFragmentListFragment() {
        super();
    }

    /**
     * Obtiene una nuev instancia
     * @return fragment
     */
    public static CurrencyFragmentListFragment newInstance() {
        CurrencyFragmentListFragment fragment = new CurrencyFragmentListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        CryptoCurrenciesApi api = new CryptoCurrenciesApi(this.getContext(), new ConfigurationRinkeby());
        recyclerView.setAdapter(new CurrencyFragmentListRecyclerViewAdapter(mListener, api.getMyCurrenciesBalance()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnWalletCurrencyListSelectedListener) {
            mListener = (OnWalletCurrencyListSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnWalletCurrencyListSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
