package ar.com.betex.betexmobile.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;

public class PlaceBetView extends FrameLayout {
    private Market market;
    private BigInteger runnerId;
    private String odd;
    private boolean isBackBet;

    private Button placeBetButton;
    private EditText oddValue;
    private TextView title;
    private TextView betCostValue;
    private EditText stakeValue;

    public PlaceBetView(Context context) {
        super(context);
        initView();
    }

    public PlaceBetView(Context context, Market market, BigInteger runnerId, String odd, boolean isBackBet) {
        super(context);
        this.market = market;
        this.runnerId = runnerId;
        this.odd = odd;
        this.isBackBet = isBackBet;
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.place_bet_layout, null);
        addView(view);

        placeBetButton = this.findViewById(R.id.placeBetButton);
        placeBetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Acá se colocal la apuesta con smart contract", Toast.LENGTH_LONG).show();
            }
        });



        title = this.findViewById(R.id.title);
        StringBuffer sbTittle = new StringBuffer();
        if (this.isBackBet){
            sbTittle.append(getResources().getString(R.string.back_bet_text));
        }
        else{
            sbTittle.append(getResources().getString(R.string.lay_bet_text));
        }
        sbTittle.append(" - ");
        sbTittle.append(this.market.getRunnerByRunnerId(this.runnerId).getRunnerName());
        title.setText(sbTittle.toString());

        betCostValue = this.findViewById(R.id.betCostValue);
        stakeValue = this.findViewById(R.id.stakeValue);

        //Valor de la apuesta
        oddValue = this.findViewById(R.id.oddValue);
        oddValue.setText(odd);

    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public BigInteger getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(BigInteger runnerId) {
        this.runnerId = runnerId;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }
}
