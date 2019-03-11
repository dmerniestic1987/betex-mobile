package ar.com.betex.betexmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Currency;
import ar.com.betex.betexmobile.fragments.listener.OnWalletCurrencyListSelectedListener;

import java.math.BigDecimal;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Currency} and makes a call to the
 * specified {@link OnWalletCurrencyListSelectedListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CurrencyFragmentListRecyclerViewAdapter extends RecyclerView.Adapter<CurrencyFragmentListRecyclerViewAdapter.ViewHolder> {

    private final List<Currency> mValues;
    private final OnWalletCurrencyListSelectedListener mListener;

    public CurrencyFragmentListRecyclerViewAdapter(List<Currency> items, OnWalletCurrencyListSelectedListener listener) {
        mValues = items;
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
        holder.currency = mValues.get(position);
        holder.currencyName.setText(mValues.get(position).getCurrencyName());
        holder.currencyValue.setText(mValues.get(position).getBalance().toString());
        holder.currencySymbol.setText(mValues.get(position).getSymbol());
        holder.currencyImg.setImageResource(mValues.get(position).getImgId());
        holder.currencyInUsd.setText(mValues.get(position).getValueInUsd().toString());

        BigDecimal balanceInUsde = mValues.get(position).getValueInUsd().multiply(mValues.get(position).getBalance()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        holder.currencyBalanceInUsd.setText(balanceInUsde.toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onCurrencySelected(holder.currency);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView currencyName;
        public final TextView currencyValue;
        public final TextView currencySymbol;
        public final ImageView currencyImg;
        public final TextView currencyBalanceInUsd;
        public final TextView currencyInUsd;

        public Currency currency;

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
