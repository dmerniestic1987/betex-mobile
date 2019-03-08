package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.components.PlaceBetView;
import ar.com.betex.betexmobile.fragments.listener.OnPlaceBetFragmentListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnPlaceBetFragmentListener} interface
 * to handle interaction events.
 * Use the {@link PlaceBetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceBetFragment extends Fragment {
    private static final String PARAM_MARKET = "param_market";
    private static final String PARAM_INITIAL_ODD = "param_initial_odd";
    private static final String PARAM_RUNNER_ID = "param_runner_id";
    private static final String PARAM_BET_TYPE = "param_bet_type";

    private Market market;
    private BigInteger runnerId;
    private boolean isBackBet;
    private String odd;
    private PlaceBetView placeBetView;

    public static final String TAG = "PlaceBetFragment";

    private OnPlaceBetFragmentListener mListener;

    public PlaceBetFragment() {
        super();
        this.isBackBet = true;
    }

    /**
     * Crea una nueva instancia del fragment para colocar apuestas
     * @param market El mercado al que se quiere apostar.
     * @param initialOdd La cuota inicial de la apuesta.
     * @param runnerId Es el ID por el cual se desea apostar
     * @param isBackBet Es el tipo de apuesta. True si es a favor (back) o false si es Lay (en contra)
     * @return A new instance of fragment PlaceBetFragment.
     */
    public static PlaceBetFragment newInstance(Market market, String initialOdd, BigInteger runnerId, boolean isBackBet) {
        PlaceBetFragment fragment = new PlaceBetFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARAM_MARKET, market);
        args.putString(PARAM_INITIAL_ODD, initialOdd);
        args.putSerializable(PARAM_RUNNER_ID, runnerId);
        args.putBoolean(PARAM_BET_TYPE, isBackBet);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FrameLayout frame = getActivity().findViewById(R.id.placeBetContainer);
        frame.addView(this.placeBetView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.market = (Market) getArguments().getSerializable(PARAM_MARKET);
            this.odd = getArguments().getString(PARAM_INITIAL_ODD);
            this.runnerId = (BigInteger) getArguments().getSerializable(PARAM_RUNNER_ID);
            this.isBackBet = getArguments().getBoolean(PARAM_BET_TYPE);
            this.placeBetView = new PlaceBetView(getContext(), market, runnerId, odd, isBackBet);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_bet, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPlaceBetFragmentListener) {
            mListener = (OnPlaceBetFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPlaceBetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
