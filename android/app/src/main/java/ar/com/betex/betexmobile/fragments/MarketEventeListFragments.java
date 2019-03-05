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
import java.util.Date;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.ItemMarketEventWithDrawRecyclerViewAdapter;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.Runner;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnEventMarketInteractionListener}
 * interface.
 */
public class MarketEventeListFragments extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnEventMarketInteractionListener mListener;
    private List<Market> marketList;
    private ItemMarketEventWithDrawRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MarketEventeListFragments() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        marketList = new ArrayList<>();
        Market m = new Market();
        m.setCompetitionId("19191");
        m.setCompetitionName("Copa Libertadores");
        m.setCountryCode("AR");
        m.setEventId(new BigInteger("1"));
        m.setMarketId(new BigInteger("123"));
        m.setStartDateGMT(new Date());
        m.addRunner(new Runner(new BigInteger("1"), "Boca Juniors"));
        m.addRunner(new Runner(new BigInteger("8888"), "Empate"));
        m.addRunner(new Runner(new BigInteger("2"), "River Plate"));
        marketList.add(m);

        Market m2 = new Market();
        m2.setCompetitionId("19192");
        m2.setCompetitionName("Supercopa");
        m2.setCountryCode("AR");
        m2.setEventId(new BigInteger("2"));
        m2.setMarketId(new BigInteger("124"));
        m2.setStartDateGMT(new Date());
        m2.addRunner(new Runner(new BigInteger("55"), "Villa Dálmine"));
        m2.addRunner(new Runner(new BigInteger("8888"), "Empate"));
        m2.addRunner(new Runner(new BigInteger("65"), "Sacachispas"));
        marketList.add(m2);

        Market m3 = new Market();
        m2.setCompetitionId("877");
        m2.setCompetitionName("Champions League");
        m2.setCountryCode("AR");
        m2.setEventId(new BigInteger("12"));
        m2.setMarketId(new BigInteger("887"));
        m2.setStartDateGMT(new Date());
        m2.addRunner(new Runner(new BigInteger("43"), "Nueva Chicago"));
        m2.addRunner(new Runner(new BigInteger("8888"), "Empate"));
        m2.addRunner(new Runner(new BigInteger("9989"), "Manchester United"));
        marketList.add(m3);

        marketList.add(m);
        marketList.add(m2);
        marketList.add(m3);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market_event_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
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
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnEventMarketInteractionListener {
        void onListFragmentInteraction(Market item);
    }
}
