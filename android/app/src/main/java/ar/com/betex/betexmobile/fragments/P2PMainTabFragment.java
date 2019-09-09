package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import ar.com.betex.betexmobile.R;

/**
 * Retos
 */
public class P2PMainTabFragment extends TabWithFabFragment {
    public static final String TAG = "P2PMainTabFragment";

    public P2PMainTabFragment(){
        super();
    }

    @Override
    protected void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(P2PBetFragment.newInstance());
        fragments.add(new P2PBetFragment());
    }


    /**
     * Utiliza un método factory para obtener una nueva instacia del fragment
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static P2PMainTabFragment newInstance(Context context) {
        P2PMainTabFragment fragment = new P2PMainTabFragment();
        Bundle args = new Bundle();
        ArrayList<String> tabTitles = new ArrayList<>();

        args.putStringArrayList(ARG_TITLES, tabTitles);
        tabTitles.add( context.getResources().getString(R.string.tab_title_open_challenges) );
        tabTitles.add( context.getResources().getString(R.string.tab_title_my_challenges_challenges) );
        fragment.setArguments(args);
        return fragment;
    }
}
