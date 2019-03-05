package ar.com.betex.betexmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.Runner;
import ar.com.betex.betexmobile.fragments.MarketEventeListFragments.OnEventMarketInteractionListener;

import java.text.SimpleDateFormat;
import java.util.List;

public class ItemMarketEventWithDrawRecyclerViewAdapter extends RecyclerView.Adapter<ItemMarketEventWithDrawRecyclerViewAdapter.ItemMarketEventViewHolder> {

    private final List<Market> markets;
    private final OnEventMarketInteractionListener mListener;

    public ItemMarketEventWithDrawRecyclerViewAdapter(List<Market> items, OnEventMarketInteractionListener listener) {
        markets = items;
        mListener = listener;
    }

    @Override
    public ItemMarketEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market_event_with_draw, parent, false);
        return new ItemMarketEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemMarketEventViewHolder holder, int position) {
        holder.mItem = markets.get(position);

        holder.competitionName.setText(holder.mItem.getCompetitionName());
        Runner localRunner = holder.mItem.getRunners().get(0);
        holder.imgLocalCompetitor.setImageResource(localRunner.getImageId());
        holder.localCompetitorName.setText(localRunner.getRunnerName());

        Runner visitorRunner = holder.mItem.getRunners().get(2);
        holder.visitorCompetitorName.setText(visitorRunner.getRunnerName());
        holder.imgVisitorCompetitor.setImageResource(visitorRunner.getImageId());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        holder.time.setText(sdf.format(holder.mItem.getStartDateGMT()));

        //Click en "Ver más"
        holder.viewMoreMarkets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onShowMoreMaketsSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }


    public class ItemMarketEventViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView time;
        public final TextView competitionName;
        public final TextView localCompetitorName;
        public final TextView visitorCompetitorName;
        public final TextView drawName;
        public final TextView viewMoreMarkets;
        public final ImageView imgVisitorCompetitor;
        public final ImageView imgLocalCompetitor;

        public Market mItem;

        public ItemMarketEventViewHolder(View view) {
            super(view);
            mView = view;
            localCompetitorName = (TextView) view.findViewById(R.id.localCompetitorName);
            visitorCompetitorName = (TextView) view.findViewById(R.id.visitorCompetitorName);
            drawName = (TextView) view.findViewById(R.id.drawName);
            time = (TextView) view.findViewById(R.id.time);
            competitionName = (TextView) view.findViewById(R.id.competitionName);
            viewMoreMarkets = view.findViewById(R.id.viewMoreMarkets);
            imgVisitorCompetitor = view.findViewById(R.id.imgVisitorCompetitor);
            imgLocalCompetitor = view.findViewById(R.id.imgLocalCompetitor);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + visitorCompetitorName.getText() + "'";
        }
    }
}
