package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.util.BetexUtils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MyBetsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyBetsFragment extends BetexFragment {
    public static String TAG = "MyBetsFragment";

    public MyBetsFragment() {
        super();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BetexUtils.CURRENT_FRAGMENT_SELECTED_BY_USER, TAG);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MyBetsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBetsFragment newInstance() {
        MyBetsFragment fragment = new MyBetsFragment();
        return fragment;
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyBetsListFragmentFragment fragments = new MyBetsListFragmentFragment();
        this.replaceFragment(fragments, MarketEventListFragments.TAG, null, R.id.myBetsFragmentList );
    }
*/
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_bets, container, false);
    }
}
