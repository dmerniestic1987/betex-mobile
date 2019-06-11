package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.entities.CryptoAsset;
import ar.com.betex.betexmobile.blockchain.utils.BetexWeb3jUtils;
import ar.com.betex.betexmobile.blockchain.wallet.FileBetexWallet;

public class CurrencyFragment extends Fragment {
    private static final String ARG_CURRENCY = "ARG_CURRENCY";
    private CryptoAsset currency;
    public static final String TAG = "CurrencyFragment";
    public CurrencyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param currency Parameter 1.
     * @return A new instance of fragment CurrencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyFragment newInstance(CryptoAsset currency) {
        CurrencyFragment fragment = new CurrencyFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CURRENCY, currency);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currency = (CryptoAsset) getArguments().getSerializable(ARG_CURRENCY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance();
        NumberFormat formatNumber = NumberFormat.getNumberInstance();

        BigInteger balance = currency.getBalance();
        BigDecimal bdBalance = new BigDecimal(balance);

        if (!currency.isToken()){
            bdBalance = BetexWeb3jUtils.weiToEther(balance);
        }

        BigDecimal balanceInUsde = currency.getValueInUsd().multiply(bdBalance)
                                            .setScale(2, BigDecimal.ROUND_HALF_DOWN);

        View view = inflater.inflate(R.layout.fragment_currency, container, false);
        TextView title = view.findViewById(R.id.currencyBalance);
        title.setText(formatNumber.format(bdBalance));

        TextView currencySymbol = view.findViewById(R.id.currencySymbol);
        currencySymbol.setText(currency.getSymbol());

        TextView currencyInUsd = view.findViewById(R.id.currencyInUsd);
        currencyInUsd.setText("En dólares: " + formatCurrency.format(currency.getValueInUsd()));

        TextView balanceInUsd = view.findViewById(R.id.balanceInUsd);
        balanceInUsd.setText("Saldo dólares: " + formatCurrency.format(balanceInUsde));

        ImageView currencyImage = view.findViewById(R.id.currencyImage);
        currencyImage.setImageResource(currency.getImgId());

        EditText editTextAddress = view.findViewById(R.id.address);
        editTextAddress.setText("My Wallet: " + FileBetexWallet.getInstance(this.getContext()).getAddress());
        return view;
    }

}
