package ar.com.betex.betexmobile.components;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;

public class PlaceBetView extends FrameLayout {
    private Market market;
    private BigInteger runnerId;
    private String odd;
    private boolean isBackBet;

    public PlaceBetView(Context context) {
        super(context);
        initView();
    }

    public PlaceBetView(Context context, Market market, BigInteger runnerId, String odd, boolean isBackBet) {
        super(context);
        initView();
        this.market = market;
        this.runnerId = runnerId;
        this.odd = odd;
        this.isBackBet = isBackBet;
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.place_bet_layout, null);
        addView(view);
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
