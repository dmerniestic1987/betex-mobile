package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.CurrencyFragmentListRecyclerViewAdapter;
import ar.com.betex.betexmobile.beans.Currency;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnWalletCurrencyListSelectedListener}
 * interface.
 */
public class CurrencyFragmentListFragment extends Fragment {
    private static final String ARG_CURRENCY_LIST = "ARG_CURRENCY_LIST";
    private OnWalletCurrencyListSelectedListener mListener;
    List<Currency> currencies;

    public static final String TAG = "CurrencyFragmentListFragment";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CurrencyFragmentListFragment() {
        this.currencies = new ArrayList<>();
    }

    public static CurrencyFragmentListFragment newInstance(List<Currency> currencies) {
        CurrencyFragmentListFragment fragment = new CurrencyFragmentListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CURRENCY_LIST, new ArrayList<>(currencies));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            currencies = (List<Currency>) getArguments().getSerializable(ARG_CURRENCY_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new CurrencyFragmentListRecyclerViewAdapter(this.currencies, mListener));
        }
        return view;
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
