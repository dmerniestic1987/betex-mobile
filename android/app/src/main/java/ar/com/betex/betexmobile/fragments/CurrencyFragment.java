package ar.com.betex.betexmobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Currency;

public class CurrencyFragment extends Fragment {
    private static final String ARG_CURRENCY = "ARG_CURRENCY";
    private Currency currency;
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
    public static CurrencyFragment newInstance(Currency currency) {
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
            currency = (Currency) getArguments().getSerializable(ARG_CURRENCY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency, container, false);
        TextView title = view.findViewById(R.id.currencyTitle);
        title.setText(currency.getCurrencyName());

        TextView currencyBalance = view.findViewById(R.id.currencyBalance);
        currencyBalance.setText(currency.getBalance().toString() + " " + currency.getSymbol());

        ImageView currencyImage = view.findViewById(R.id.currencyImage);
        currencyImage.setImageResource(currency.getImgId());
        return view;
    }

}
