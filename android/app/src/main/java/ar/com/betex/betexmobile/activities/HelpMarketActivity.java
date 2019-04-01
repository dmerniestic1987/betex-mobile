package ar.com.betex.betexmobile.activities;

import android.os.Bundle;
import com.stepstone.stepper.StepperLayout;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.adapters.HelpMarketStepperAdapter;

public class HelpMarketActivity extends WellcomeActivity{
    private StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        stepperLayout = this.findViewById(R.id.stepperLayout);
        stepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        stepperLayout.setAdapter(new HelpMarketStepperAdapter(getSupportFragmentManager(), this));
        stepperLayout.setListener(this);
    }
}
