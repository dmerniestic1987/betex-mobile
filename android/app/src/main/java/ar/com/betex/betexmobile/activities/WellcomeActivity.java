package ar.com.betex.betexmobile.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.WellcomeStepperAdapter;

public class WellcomeActivity extends AppCompatActivity implements StepperLayout.StepperListener {
    private StepperLayout stepperLayout;
    @Override
    public void onCompleted(View completeButton) {
        Intent myIntent = new Intent(WellcomeActivity.this, MainActivity.class);
        this.startActivity(myIntent);
    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        stepperLayout = this.findViewById(R.id.stepperLayout);
        stepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        stepperLayout.setAdapter(new WellcomeStepperAdapter(getSupportFragmentManager(), this));
        stepperLayout.setListener(this);
    }
}
