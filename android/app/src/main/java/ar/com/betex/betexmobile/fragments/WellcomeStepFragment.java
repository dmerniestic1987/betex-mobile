package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import ar.com.betex.betexmobile.R;

public class WellcomeStepFragment extends Fragment implements Step {
    public static final String CURRENT_STEP_POSITION_KEY = "current_step_position";
    private int currentStepPosition;
    private TextView title;
    private TextView text;
    private ImageView img;

    public WellcomeStepFragment() {
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
        return inflater.inflate(R.layout.fragment_wellcome_step, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.text);
        img = view.findViewById(R.id.img);

        if (currentStepPosition == 1){
            title.setText(getContext().getResources().getString(R.string.wellcome_title_02));
            text.setText(getContext().getResources().getString(R.string.wellcome_text_02));
            img.setImageResource(R.drawable.betex_mobile2);
        }

        if (currentStepPosition == 2){
            title.setText(getContext().getResources().getString(R.string.wellcome_title_03));
            text.setText(getContext().getResources().getString(R.string.wellcome_text_03));
            img.setImageResource(R.drawable.betex_mobile3);
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
