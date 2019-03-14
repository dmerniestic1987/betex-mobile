package ar.com.betex.betexmobile.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ar.com.betex.betexmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyBetsButtonBar.OnMyBetTypeFilterClickedListener} interface
 * to handle interaction events.
 * Use the {@link MyBetsButtonBar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyBetsButtonBar extends Fragment implements View.OnClickListener {
    private OnMyBetTypeFilterClickedListener listener;
    private Button myBetsInPlayButton;
    private Button allMyBetsButton;
    private Button myBetBackButton;

    public MyBetsButtonBar() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.myBetsInPlayButton){
            listener.onMyBetTypeClicked(getResources().getString(R.string.my_bets_in_play_title));
        }

        if (v.getId() == R.id.allMyBetsButton){
            listener.onMyBetTypeClicked(getResources().getString(R.string.my_bets_all_tittle));
        }

        if (v.getId() == R.id.myBetBackButton){
            listener.onMyBetTypeClicked(getResources().getString(R.string.my_bets_back));
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.myBetsInPlayButton = view.findViewById(R.id.myBetsInPlayButton);
        this.myBetsInPlayButton.setOnClickListener(this);

        this.allMyBetsButton = view.findViewById(R.id.allMyBetsButton);
        this.allMyBetsButton.setOnClickListener(this);

        this.myBetBackButton = view.findViewById(R.id.myBetBackButton);
        this.myBetBackButton.setOnClickListener(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyBetsButtonBar.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBetsButtonBar newInstance(String param1, String param2) {
        MyBetsButtonBar fragment = new MyBetsButtonBar();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_bets_button_bar, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (MyBetsButtonBar.OnMyBetTypeFilterClickedListener) context;
        } catch (Exception e) {
            throw new RuntimeException(context.toString() + " la comunciación no se ha podido realizar");
        }
    }

    public interface OnMyBetTypeFilterClickedListener {
        void onMyBetTypeClicked(String eventType);
    }
}
