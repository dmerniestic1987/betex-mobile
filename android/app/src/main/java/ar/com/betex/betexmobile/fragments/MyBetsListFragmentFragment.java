package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.fragments.dummy.DummyContent;
import ar.com.betex.betexmobile.fragments.dummy.DummyContent.DummyItem;
import ar.com.betex.betexmobile.fragments.listener.OnMyBetSelectedListener;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnMyBetSelectedListener}
 * interface.
 */
public class MyBetsListFragmentFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnMyBetSelectedListener mListener;
    public static final String TAG = "MyBetsListFragmentFragment";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyBetsListFragmentFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyBetsListFragmentFragment newInstance() {
        MyBetsListFragmentFragment fragment = new MyBetsListFragmentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mybets_list_fragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyBetsListFragmentRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMyBetSelectedListener) {
            mListener = (OnMyBetSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMyBetSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
