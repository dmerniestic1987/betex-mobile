package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *  interface
 * to handle interaction events.
 * Use the {@link MyBetFilterBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyBetFilterBarFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MyBetFilterBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyBetFilterBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBetFilterBarFragment newInstance(String param1, String param2) {
        MyBetFilterBarFragment fragment = new MyBetFilterBarFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_bet_filter_bar, container, false);
    }
}
