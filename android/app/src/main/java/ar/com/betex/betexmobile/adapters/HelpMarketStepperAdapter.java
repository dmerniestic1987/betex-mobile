package ar.com.betex.betexmobile.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.fragments.HelpStepFragment;

public class HelpMarketStepperAdapter extends AbstractFragmentStepAdapter {

    public HelpMarketStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        //Primera pantalla
        final HelpStepFragment step = new HelpStepFragment();
        Bundle b = new Bundle();
        b.putInt(HelpStepFragment.CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context).setTitle("Titulo");
        switch (position) {
            case 0: case 1: case 2: case 3:
                builder
                        .setEndButtonLabel(context.getResources().getString(R.string.understood_text))
                        .setBackButtonLabel(context.getResources().getString(R.string.go_back_text));
                break;
            case 4:
                builder
                        .setBackButtonLabel(context.getResources().getString(R.string.go_back_text))
                        .setEndButtonLabel(context.getResources().getString(R.string.finish_text));
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}
