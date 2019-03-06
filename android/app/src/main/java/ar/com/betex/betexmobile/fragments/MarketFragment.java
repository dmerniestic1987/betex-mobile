package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
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
import ar.com.betex.betexmobile.beans.develop.DevelopUtils;

/**
 * MarketFragment es la pantalla principal que se ve cuando el usuario
 * ingresa en la opción "Deportes" del BottomNavigationBar de la App o bien
 * a la opción "Deportes y mercados" del NavigationBar
 *
 */
public class MarketFragment extends Fragment{
    private static String TAG = "MarketFragment";
    private TextView eventTypeTitle;

    public MarketFragment() {
        super();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarketFragment.
     */
    public static MarketFragment newInstance(String param1, String param2) {
        MarketFragment fragment = new MarketFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
            MarketEventListFragments fragments = MarketEventListFragments.newInstance(DevelopUtils.hardcodeFutbalMarketList());
            transaction.add(R.id.marketsListContainer, fragments, MarketEventListFragments.TAG);
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
        eventTypeTitle = (TextView) getActivity().findViewById(R.id.eventTypeTitle);
    }

    /**
     * Actualiza el título del tipo de evento.
     * @param eventType
     */
    public void setEventTypeTitle(String eventType){
        eventTypeTitle.setText(eventType);
    }

    public void drawPlaceBackBetFragment(Market itemSelected, String oddSelected, BigInteger runnerId) {
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        PlaceBackBetFragment newFragment = PlaceBackBetFragment.newInstance(itemSelected, oddSelected, runnerId);

        transaction.replace(R.id.marketsListContainer, newFragment, PlaceBackBetFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void drawMarketListFragment(List<Market> newMarketList) {
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        MarketEventListFragments fragments = MarketEventListFragments.newInstance(newMarketList);

        transaction.replace(R.id.marketsListContainer, fragments, MarketEventListFragments.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
