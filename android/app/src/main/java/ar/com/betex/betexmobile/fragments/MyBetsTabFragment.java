package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import ar.com.betex.betexmobile.R;

/**
 * Retos
 */
public class MyBetsTabFragment extends TabFragment {
    public static final String TAG = "MyBetsTabFragment";

    public MyBetsTabFragment(){
        super();
    }

    @Override
    protected void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new MyBetsFragment());
        fragments.add(MyBetsFragment.newInstance());
        fragments.add(new MyBetsFragment());
    }


    /**
     * Utiliza un método factory para obtener una nueva instacia del fragment
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBetsTabFragment newInstance(Context context) {
        MyBetsTabFragment fragment = new MyBetsTabFragment();
        Bundle args = new Bundle();
        ArrayList<String> tabTitles = new ArrayList<>();

        args.putStringArrayList(ARG_TITLES, tabTitles);
        tabTitles.add( context.getResources().getString(R.string.my_bets_in_play_title) );
        tabTitles.add( context.getResources().getString(R.string.my_bets_all_tittle) );
        tabTitles.add( context.getResources().getString(R.string.my_bets_back) );

        fragment.setArguments(args);
        return fragment;
    }
}
