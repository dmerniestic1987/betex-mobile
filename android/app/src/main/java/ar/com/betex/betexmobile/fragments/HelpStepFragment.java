package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import ar.com.betex.betexmobile.R;

public class HelpStepFragment extends Fragment implements Step {
    public static final String CURRENT_STEP_POSITION_KEY = "current_step_position";
    private int currentStepPosition;
    private TextView title;
    private TextView text;
    private TextView text2;
    private TextView txtImg;
    private TextView txtImg2;
    private ImageView img;
    private ImageView img2;
    private LinearLayout secondImage;

    public HelpStepFragment() {
        super();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentStepPosition = getArguments().getInt(CURRENT_STEP_POSITION_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_step, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.text);
        img = view.findViewById(R.id.img);
        img2 = view.findViewById(R.id.img2);
        txtImg = view.findViewById(R.id.txtImg);
        txtImg2 = view.findViewById(R.id.txtImg2);
        secondImage = view.findViewById(R.id.secondImage);
        text2 = view.findViewById(R.id.text2);

        switch (currentStepPosition){
            case 0:
                break;

            case 1:
                title.setText(getContext().getResources().getString(R.string.help_title_02));
                text.setText(getContext().getResources().getString(R.string.help_text_02));
                img.setImageResource(R.drawable.help_market_accept);
                secondImage.setVisibility(View.GONE);
                break;

            case 2:
                title.setText(getContext().getResources().getString(R.string.help_title_03));
                text.setText(getContext().getResources().getString(R.string.help_text_03));
                text2.setVisibility(View.VISIBLE);
                text2.setText(getContext().getResources().getString(R.string.help_text2_03));
                secondImage.setVisibility(View.GONE);
                break;

            case 3:
                title.setText(getContext().getResources().getString(R.string.help_title_03));
                text.setText(getContext().getResources().getString(R.string.help_text2_04));

                img.setImageResource(R.drawable.help_market_place_bet);
                img2.setImageResource(R.drawable.help_market_my_bets);
                txtImg.setText(getContext().getResources().getString(R.string.help_text_my_bets));
                break;

            case 4:
                title.setText(getContext().getResources().getString(R.string.help_title_rules));
                text.setText(getContext().getResources().getString(R.string.help_text_rules));
                img.setImageResource(R.drawable.help_market_rules);
                secondImage.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
    }

    @Override
    public void onError(@NonNull VerificationError error) {
    }

}
