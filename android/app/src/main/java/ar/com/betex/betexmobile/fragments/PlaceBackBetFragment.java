package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.fragments.listener.OnPlaceBetFragmentListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnPlaceBetFragmentListener} interface
 * to handle interaction events.
 * Use the {@link PlaceBackBetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceBackBetFragment extends Fragment {
    protected static final String MARKET_PARAM  = "market_param";
    protected static final String ODD_PARAM     = "odd_param";
    protected static final String RUNNER_PARAM  = "runnerId_param";
    protected Market market;
    protected String odd;
    protected BigInteger runnerId;

    private OnPlaceBetFragmentListener placeBetListener;

    public static final String TAG ="PlaceBackBetFragment";

    public PlaceBackBetFragment() {
        super();
    }

    /**
     * Crea una nueva instancia del Fragment
     * @param marketSelected - El mercado seleccionado
     * @param oddSelected - La cueota de la apuesta
     * @param runnerId - El ID del Runner al que se le realiza la apuesta
     * @return fragment
     */
    public static PlaceBackBetFragment newInstance(Market marketSelected, String oddSelected, BigInteger runnerId) {
        PlaceBackBetFragment fragment = new PlaceBackBetFragment();
        Bundle args = new Bundle();
        args.putSerializable(MARKET_PARAM, marketSelected);
        args.putString(ODD_PARAM, oddSelected);
        args.putSerializable(RUNNER_PARAM, runnerId);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            market = (Market) getArguments().getSerializable(MARKET_PARAM);
            odd = getArguments().getString(ODD_PARAM);
            runnerId = (BigInteger) getArguments().getSerializable(RUNNER_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_back_bet, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPlaceBetFragmentListener) {
            placeBetListener = (OnPlaceBetFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPlaceBetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        placeBetListener = null;
    }
}
