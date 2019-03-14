package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.util.BetexUtils;
import ar.com.betex.betexmobile.util.DevelopUtils;

/**
 * MarketFragment es la pantalla principal que se ve cuando el usuario
 * ingresa en la opción "Deportes" del BottomNavigationBar de la App o bien
 * a la opción "Deportes y mercados" del NavigationBar
 *
 */
public class MarketFragment extends Fragment{
    private TextView eventTypeTitle;
    public static final String TAG = "MarketFragment";

    public MarketFragment() {
        super();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MarketFragment.
     */
    public static MarketFragment newInstance() {
        MarketFragment fragment = new MarketFragment();
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BetexUtils.CURRENT_FRAGMENT_SELECTED_BY_USER, TAG);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
            MarketEventListFragments fragments = MarketEventListFragments.newInstance(DevelopUtils.hardcodeFutbalMarketList());
            transaction.replace(R.id.marketListFragmentContainer, fragments, MarketEventListFragments.TAG);
            transaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_market, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
    }

    @Override
    public void onStart(){
        super.onStart();
        eventTypeTitle = (TextView) getActivity().findViewById(R.id.eventTitles);
    }

    /**
     * Actualiza el título del tipo de evento.
     * @param eventType
     */
    public void setEventTypeTitle(String eventType){
        eventTypeTitle.setText(eventType);
    }

    /**
     * Actualiza el fragment de los event Types
     * @param newMarketList
     */
    public void drawMarketListFragment(List<Market> newMarketList) {
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        MarketEventListFragments fragments = MarketEventListFragments.newInstance(newMarketList);

        transaction.replace(R.id.marketListFragmentContainer, fragments, MarketEventListFragments.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * Actualiza el fragment de los event Types
     * @param newMarketList
     */
    public void drawAllMarketsByEvent(List<Market> newMarketList) {
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        AllMarketsEventListFragments fragments = AllMarketsEventListFragments.newInstance(newMarketList);

        transaction.replace(R.id.marketListFragmentContainer, fragments, AllMarketsEventListFragments.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * Dibujoa la pantalla de apuestas para colocar una nueva apuesta
     * @param marketSelected
     * @param oddSelected
     * @param runnerId
     * @param isBack True es una apuesta a favor, false de lo contrario
     */
    public void showPlaceBetScreen(Market marketSelected, String oddSelected, BigInteger runnerId, boolean isBack){
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        PlaceBetFragment fragments = PlaceBetFragment.newInstance(marketSelected, oddSelected, runnerId, isBack);

        transaction.replace(R.id.marketListFragmentContainer, fragments, PlaceBetFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
