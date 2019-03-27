package ar.com.betex.betexmobile.fragments;

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
    }

    @Override
    protected void initTitles(){
        this.titles = new ArrayList<>();
        this.titles.add( getContext().getResources().getString(R.string.tab_title_open_challenges) );
        this.titles.add( getContext().getResources().getString(R.string.tab_title_my_challenges_challenges) );
    }
    /**
     * Utiliza un método factory para obtener una nueva instacia del fragment
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChallengeTabFragment newInstance() {
        ChallengeTabFragment fragment = new ChallengeTabFragment();
        return fragment;
    }
}
