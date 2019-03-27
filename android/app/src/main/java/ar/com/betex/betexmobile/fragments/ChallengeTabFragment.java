package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import ar.com.betex.betexmobile.R;

/**
 * Retos
 */
public class ChallengeTabFragment  extends TabFragment{
    public static final String TAG = "ChallengeTabFragment";

    public ChallengeTabFragment(){
        super();
    }

    @Override
    protected void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(WalletFragment.newInstance());
        fragments.add(MyBetsFragment.newInstance());
        fragments.add(new MarketButtonBarFragment());
    }


    /**
     * Utiliza un método factory para obtener una nueva instacia del fragment
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChallengeTabFragment newInstance(Context context) {
        ChallengeTabFragment fragment = new ChallengeTabFragment();
        Bundle args = new Bundle();
        ArrayList<String> tabTitles = new ArrayList<>();

        args.putStringArrayList(ARG_TITLES, tabTitles);
        tabTitles.add( context.getResources().getString(R.string.tab_title_open_challenges) );
        tabTitles.add( context.getResources().getString(R.string.tab_title_my_challenges_challenges) );
        tabTitles.add( context.getResources().getString(R.string.tab_title_my_contacts_challenges) );
        fragment.setArguments(args);
        return fragment;
    }
}
