package ar.com.betex.betexmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.fragments.MarketEventeListFragments.OnEventMarketInteractionListener;
import java.util.List;

public class ItemMarketEventWithDrawRecyclerViewAdapter extends RecyclerView.Adapter<ItemMarketEventWithDrawRecyclerViewAdapter.ViewHolder> {

    private final List<Market> markets;
    private final OnEventMarketInteractionListener mListener;

    public ItemMarketEventWithDrawRecyclerViewAdapter(List<Market> items, OnEventMarketInteractionListener listener) {
        markets = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market_event_with_draw, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = markets.get(position);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView time;
        public final TextView competitionName;
        public final TextView localCompetitorName;
        public final TextView visitorCompetitorName;
        public final TextView drawName;

        public Market mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            localCompetitorName = (TextView) view.findViewById(R.id.localCompetitorName);
            visitorCompetitorName = (TextView) view.findViewById(R.id.visitorCompetitorName);
            drawName = (TextView) view.findViewById(R.id.drawName);
            time = (TextView) view.findViewById(R.id.time);
            competitionName = (TextView) view.findViewById(R.id.competitionName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + visitorCompetitorName.getText() + "'";
        }
    }
}
