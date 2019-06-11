package ar.com.betex.betexmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.blockchain.entities.CryptoAsset;
import ar.com.betex.betexmobile.blockchain.utils.BetexWeb3jUtils;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter para los item s de la lista de wallets.
 * @author Diego Mernies
 */
public class CurrencyFragmentListRecyclerViewAdapter
            extends RecyclerView.Adapter<CurrencyFragmentListRecyclerViewAdapter.ViewHolder> {

    private final List<CryptoAsset> mCurrencies;
    private final OnWalletCurrencyListSelectedListener mListener;

    public CurrencyFragmentListRecyclerViewAdapter(OnWalletCurrencyListSelectedListener listener, List<CryptoAsset> currencies) {
        mCurrencies = currencies;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_currency, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance();
        NumberFormat formatNumber = NumberFormat.getNumberInstance();

        holder.currency = mCurrencies.get(position);
        holder.currencyName.setText(mCurrencies.get(position).getCurrencyName());


        holder.currencySymbol.setText(mCurrencies.get(position).getSymbol());
        holder.currencyImg.setImageResource(mCurrencies.get(position).getImgId());

        holder.currencyInUsd.setText(formatCurrency.format(mCurrencies.get(position).getValueInUsd()));

        BigInteger balance = mCurrencies.get(position).getBalance();
        BigDecimal bdBalance = new BigDecimal(balance);

        if(!mCurrencies.get(position).isToken()){
            bdBalance = BetexWeb3jUtils.weiToEther(balance);
        }

        holder.currencyValue.setText(formatNumber.format(bdBalance));

        BigDecimal balanceInUsde = mCurrencies.get(position).getValueInUsd()
                                    .multiply(bdBalance)
                                    .setScale(2, BigDecimal.ROUND_HALF_DOWN);
        holder.currencyBalanceInUsd.setText(formatCurrency.format(balanceInUsde));

        holder.mView.setOnClickListener(view -> {
            if (null != mListener) {
                mListener.onCurrencySelected(holder.currency);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView currencyName;
        public final TextView currencyValue;
        public final TextView currencySymbol;
        public final ImageView currencyImg;
        public final TextView currencyBalanceInUsd;
        public final TextView currencyInUsd;

        public CryptoAsset currency;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            currencyName = view.findViewById(R.id.currencyName);
            currencyValue = view.findViewById(R.id.currencyValue);
            currencySymbol = view.findViewById(R.id.currencySymbol);
            currencyImg = view.findViewById(R.id.currencyImg);
            currencyBalanceInUsd = view.findViewById(R.id.currencyBalanceInUsd);
            currencyInUsd = view.findViewById(R.id.currencyInUsd);
        }
    }
}
