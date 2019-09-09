package ar.com.betex.betexmobile.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;

import ar.com.betex.betexmobile.entities.Market;
import ar.com.betex.betexmobile.entities.P2pBet;
import ar.com.betex.betexmobile.fragments.listener.OnP2PBetFragmentInteractionListener;
import ar.com.betex.betexmobile.util.BetexUtils;

import java.util.List;

/**
 * Es un adapter para mostrar la un elemento de la lista de apuestas p2p.
 * @author Diego Mernies
 */
public class P2pBetItemRecyclerViewAdapter extends RecyclerView.Adapter<P2pBetItemRecyclerViewAdapter.ViewHolder> {

    private final List<P2pBet> mValues;
    private final OnP2PBetFragmentInteractionListener mListener;

    public P2pBetItemRecyclerViewAdapter(List<P2pBet> items, OnP2PBetFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fragment_p2pbet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mP2pBetItem = mValues.get(position);
        if (holder.mP2pBetItem.getMarket() == null){
            holder.mP2pBetItem.setMarket(new Market());
        }
        holder.userName.setText(BetexUtils.formatUserNameOrAddress(holder.mP2pBetItem.getCreatorUser()));
        holder.eventTitle.setText(BetexUtils.getString(holder.mP2pBetItem.getMarket().getEventName(), "-"));
        holder.marketStatus.setText(BetexUtils.getString(holder.mP2pBetItem.getMarket().getMarketStatus(), "error"));
        holder.marketTypeValue.setText(BetexUtils.getString(holder.mP2pBetItem.getMarket().getMarketType(), "error"));

        if (holder.mP2pBetItem.isBackBet()){
            holder.betType.setText(holder.mView.getResources().getString(R.string.back_bet_text));
        }
        else{
            holder.betType.setText(holder.mView.getResources().getString(R.string.lay_bet_text));
        }

        holder.betStatus.setText(BetexUtils.getString(holder.mP2pBetItem.getBetStatus(), "error"));
        holder.competitionName.setText(BetexUtils.getString(holder.mP2pBetItem.getMarket().getCompetitionName(), "error"));
        holder.eventDateValue.setText("05 sep 2019");
        holder.eventTimeValue.setText("19:30");
        holder.amountValue.setText(holder.mP2pBetItem.getAmount().toString());
        holder.cryptoAssetSymbol.setText(BetexUtils.getString(holder.mP2pBetItem.getCryptoAsset().getSymbol(), "ETH"));
        holder.eventType.setText(BetexUtils.getString(holder.mP2pBetItem.getMarket().getEventType(), "error"));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                   // mListener.onP2PBetAccepted(holder.mP2pBetItem);
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
        public P2pBet mP2pBetItem;

        public TextView userName;
        public TextView eventTitle;
        public TextView marketStatus;
        public TextView marketTypeValue;
        public TextView betType;
        public TextView betStatus;
        public TextView competitionName;
        public TextView eventDateValue;
        public TextView eventTimeValue;
        public TextView amountValue;
        public TextView cryptoAssetSymbol;
        public TextView eventType;
        public ImageView eventTypeImage;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            userName = view.findViewById(R.id.userName);
            eventTitle = view.findViewById(R.id.eventTitle);
            marketStatus = view.findViewById(R.id.marketStatus);
            marketTypeValue = view.findViewById(R.id.marketTypeValue);
            betType = view.findViewById(R.id.betType);
            betStatus = view.findViewById(R.id.marketStatus);
            competitionName = view.findViewById(R.id.competitionName);
            eventDateValue = view.findViewById(R.id.eventDateValue);
            eventTimeValue = view.findViewById(R.id.eventTimeValue);
            amountValue = view.findViewById(R.id.amountValue);
            cryptoAssetSymbol = view.findViewById(R.id.cryptoAssetSymbol);
            eventTypeImage = view.findViewById(R.id.eventTypeImage);
            eventType = view.findViewById(R.id.eventType);
        }
    }
}
