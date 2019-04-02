package ar.com.betex.betexmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.math.BigInteger;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.activities.HelpMarketActivity;
import ar.com.betex.betexmobile.activities.MainActivity;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.util.BetexUtils;
import ar.com.betex.betexmobile.util.DevelopUtils;

/**
 * MarketFragment es la pantalla principal que se ve cuando el usuario
 * ingresa en la opción "Deportes" del BottomNavigationBar de la App o bien
 * a la opción "Deportes y mercados" del NavigationBar
 *
 */
public class MarketFragment extends BetexFragment{
    private TextView eventTypeTitle;
    public static final String TAG = "MarketFragment";
    private FloatingActionsMenu menuFab;
    private FloatingActionButton actionHelpMarketBet;
    private FloatingActionButton actionCreateNewMarketBet;

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
            MarketEventListFragments fragment = MarketEventListFragments.newInstance(DevelopUtils.hardcodeFutbalMarketList());
            this.replaceFragment(fragment, MarketEventListFragments.TAG, null, R.id.marketListFragmentContainer);
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
        eventTypeTitle = getActivity().findViewById(R.id.eventTitles);
        menuFab = getActivity().findViewById(R.id.menuFab);
        actionHelpMarketBet = getActivity().findViewById(R.id.actionHelpMarketBet);

        actionHelpMarketBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), HelpMarketActivity.class);
                startActivity(myIntent);
            }
        });


        actionCreateNewMarketBet = getActivity().findViewById(R.id.actionCreateNewMarketBet);
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
        MarketEventListFragments fragment = MarketEventListFragments.newInstance(newMarketList);
        this.replaceFragment(fragment, MarketEventListFragments.TAG, null, R.id.marketListFragmentContainer);
    }

    /**
     * Actualiza el fragment de los event Types
     * @param newMarketList
     */
    public void drawAllMarketsByEvent(List<Market> newMarketList) {
        AllMarketsEventListFragments fragments = AllMarketsEventListFragments.newInstance(newMarketList);
        this.replaceFragment(fragments, AllMarketsEventListFragments.TAG, null, R.id.marketListFragmentContainer);
    }

    /**
     * Dibujoa la pantalla de apuestas para colocar una nueva apuesta
     * @param marketSelected
     * @param oddSelected
     * @param runnerId
     * @param isBack True es una apuesta a favor, false de lo contrario
     */
    public void showPlaceBetScreen(Market marketSelected, String oddSelected, BigInteger runnerId, boolean isBack){
        PlaceBetFragment fragments = PlaceBetFragment.newInstance(marketSelected, oddSelected, runnerId, isBack);
        this.replaceFragment(fragments, PlaceBetFragment.TAG, null, R.id.marketListFragmentContainer);
    }
}
