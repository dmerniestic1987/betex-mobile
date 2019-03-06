package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.ItemMarketEventWithDrawRecyclerViewAdapter;
import ar.com.betex.betexmobile.beans.Market;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnEventMarketInteractionListener}
 * interface.
 */
public class MarketEventListFragments extends Fragment {
    private static final String MARKET_LIST_PARAM = "market_list_param";
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnEventMarketInteractionListener mListener;
    private List<Market> marketList;
    private ItemMarketEventWithDrawRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    public static final String TAG = "MarketEventListFragments";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MarketEventListFragments() {
        super();
        this.marketList = new ArrayList<>();
    }

    /**
     * Obtiene una nueva instancia de la lista de mrecdos;
     * @param marketList Listado de mercados;
     * @return A new instance of fragment MarketFragment.
     */
    public static MarketEventListFragments newInstance(List<Market> marketList) {
        MarketEventListFragments fragment = new MarketEventListFragments();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.marketList = (List<Market>) getArguments().getSerializable(MARKET_LIST_PARAM);
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
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
            this.adapter = new ItemMarketEventWithDrawRecyclerViewAdapter(marketList, mListener);
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

    /**
     * Esta interfaz permite capturar los eventos que ocurren dento de la lista principal de mercados para:
     * <ul>
     *     <li>Mostrar más mercados</li>
     *     <li>Colocar apuestas a favor</li>
     *     <li>Colocar apuestas en contra</li>
     * </ul>
     */
    public interface OnEventMarketInteractionListener {
        /**
         * Se hizo click sobre la opción "Ver más"
         * @param itemSelected
         */
        void onShowMoreMaketsSelected(Market itemSelected);

        /**
         * El usuario seleccionó la colocación de una apuesta a favor de un runner
         * @param itemSelected
         * @param oddSelected
         * @param runner
         */
        void onBackBetSelected(Market itemSelected, String oddSelected, BigInteger runner);

        /**
         * El usuario seleccionó la colocación de una apuesta en contra de un runner
         * @param itemSelected
         * @param oddSelected
         * @param runner
         */
        void onLayBetSelected(Market itemSelected, String oddSelected, BigInteger runner);
    }
}
