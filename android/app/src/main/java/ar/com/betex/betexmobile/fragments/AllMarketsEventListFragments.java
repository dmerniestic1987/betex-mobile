package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.ItemAllMarketEventRecyclerViewAdapter;
import ar.com.betex.betexmobile.entities.Market;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnEventMarketInteractionListener}
 * interface.
 */
public class AllMarketsEventListFragments extends MarketEventListFragments {
    private ItemAllMarketEventRecyclerViewAdapter adapter;

    public static final String TAG = "AllMarketsEventListFragments";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllMarketsEventListFragments() {
        super();
    }

    /**
     * Obtiene una nueva instancia de la lista de mrecdos;
     * @param marketList Listado de mercados;
     * @return A new instance of fragment MarketFragment.
     */
    public static AllMarketsEventListFragments newInstance(List<Market> marketList) {
        AllMarketsEventListFragments fragment = new AllMarketsEventListFragments();
        Bundle args = new Bundle();
        ArrayList<Market> serializableArrayList = new ArrayList<>();
        if (marketList != null) {
            serializableArrayList.addAll(marketList);
        }

        args.putSerializable(MARKET_LIST_PARAM, serializableArrayList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market_event_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            this.recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            this.adapter = new ItemAllMarketEventRecyclerViewAdapter(marketList, mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEventMarketInteractionListener) {
            mListener = (OnEventMarketInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnEventMarketInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
