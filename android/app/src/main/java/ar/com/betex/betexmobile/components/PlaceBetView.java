package ar.com.betex.betexmobile.components;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.web3j.protocol.exceptions.TransactionException;

import java.math.BigDecimal;
import java.math.BigInteger;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.api.BetexMobileGondwanaApi;
import ar.com.betex.betexmobile.entities.ConfigurationRinkeby;
import ar.com.betex.betexmobile.entities.Market;

public class PlaceBetView extends FrameLayout {
    private static final String TAG = "PlaceBetView";
    private Market market;
    private BigInteger runnerId;
    private String odd;
    private boolean isBackBet;

    private Button placeBetButton;
    private EditText oddValue;
    private TextView title;
    private TextView betCostValue;
    private EditText stakeValue;
    private CheckBox btxCheckBox;
    private CheckBox etherCheckBox;

    private BetexMobileGondwanaApi betexMobileGondwanaApi;

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
        initBetexApi(context);
        initView();
    }

    private void initBetexApi(Context context) {
        betexMobileGondwanaApi = new BetexMobileGondwanaApi(context, new ConfigurationRinkeby());
        betexMobileGondwanaApi.load();
    }
    /**
     * Inicializa la vista
     */
    private void initView() {
        View view = inflate(getContext(), R.layout.place_bet_layout, null);
        addView(view);

        placeBetButton = this.findViewById(R.id.placeBetButton);
        placeBetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                placeBet(view);
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

        btxCheckBox = this.findViewById(R.id.btxCheckBox);
        btxCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (btxCheckBox.isChecked()){
                    etherCheckBox.setChecked(false);
                }
            }
        });
        etherCheckBox = this.findViewById(R.id.etherCheckBox);
        etherCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (etherCheckBox.isChecked()){
                    btxCheckBox.setChecked(false);
                }
            }
        });
        if (etherCheckBox.isChecked()){
            etherCheckBox.setChecked(false);
        }
    }

    /**
     * Coloca una apuesta determinada
     * @param v
     */
    private void placeBet(View v)  {
        if (R.id.placeBetButton != v.getId()){
            return;
        }

        BigDecimal bigDecimalOddValue = BigDecimal.ZERO;
        try {
            bigDecimalOddValue = new BigDecimal(oddValue.getText().toString());
        } catch (Exception e) {
            Toast.makeText(getContext(), "Odd inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        BigDecimal bigDecimalStakeValue = BigDecimal.ZERO;
        try {
            bigDecimalStakeValue = new BigDecimal(stakeValue.getText().toString());
        } catch (Exception e) {
            Toast.makeText(getContext(), "Stake inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (btxCheckBox.isChecked()) {
            betexMobileGondwanaApi.placeMarketBetBtx("0x5dd336c3be7b217f5b6d2daa9dd55963271c1b851bf9d6325bfbc17b109debd5"
                    , bigDecimalOddValue
                    , bigDecimalStakeValue
                    , isBackBet ).subscribe(transactionReceipt -> {
                        String blockHash = transactionReceipt.getBlockHash();
                        BigInteger blockNumber = transactionReceipt.getBlockNumber();
                        Toast.makeText(getContext(), "BTX: " + blockHash, Toast.LENGTH_LONG).show();
                    },
                    exception -> {
                        TransactionException tex = (TransactionException) exception;
                        Log.e(TAG, tex.getMessage(), exception);
                        Toast.makeText(getContext(), "Error al invocar el contrato", Toast.LENGTH_LONG).show();
                    }
            );
        }
        else{
            betexMobileGondwanaApi.placeMarketBetWei("0x5dd336c3be7b217f5b6d2daa9dd55963271c1b851bf9d6325bfbc17b109debd5"
                    , bigDecimalOddValue
                    , bigDecimalStakeValue
                    , isBackBet ).subscribe(transactionReceipt -> {
                        String blockHash = transactionReceipt.getBlockHash();
                        BigInteger blockNumber = transactionReceipt.getBlockNumber();
                        Toast.makeText(getContext(), "WEI: " + blockHash, Toast.LENGTH_LONG).show();
                    },
                    exception -> {
                        TransactionException tex = (TransactionException) exception;
                        Log.e(TAG, tex.getMessage(), exception);
                        Toast.makeText(getContext(), "Error al invocar el contrato", Toast.LENGTH_LONG).show();
                    }
            );
        }
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
