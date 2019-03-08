package ar.com.betex.betexmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

import ar.com.betex.betexmobile.R;
import ar.com.betex.betexmobile.beans.Market;
import ar.com.betex.betexmobile.beans.Runner;
import ar.com.betex.betexmobile.fragments.MarketEventListFragments.OnEventMarketInteractionListener;

public class ItemAllMarketEventRecyclerViewAdapter extends RecyclerView.Adapter<ItemAllMarketEventRecyclerViewAdapter.ItemMarketEventViewHolder> {

    private final List<Market> markets;
    private final OnEventMarketInteractionListener mListener;

    public ItemAllMarketEventRecyclerViewAdapter(List<Market> items, OnEventMarketInteractionListener listener) {
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
        holder.viewMoreMarkets.setVisibility(View.GONE);

        holder.backLocalRunnerButton.setOnClickListener(new OnBackBetClickListener(holder.mItem,  holder.mItem.getRunners().get(0).getId() ));
        holder.backDrawRunnerButton.setOnClickListener(new OnBackBetClickListener(holder.mItem,  holder.mItem.getRunners().get(1).getId() ));
        holder.backVisitorRunnerButton.setOnClickListener(new OnBackBetClickListener(holder.mItem,  holder.mItem.getRunners().get(2).getId() ));

        holder.layLocalRunnerButton.setOnClickListener(new OnLayBetClickListener(holder.mItem,  holder.mItem.getRunners().get(0).getId() ));
        holder.layDrawRunnerButton.setOnClickListener(new OnLayBetClickListener(holder.mItem,  holder.mItem.getRunners().get(1).getId() ));
        holder.layVisitorRunnerButton.setOnClickListener(new OnLayBetClickListener(holder.mItem,  holder.mItem.getRunners().get(2).getId() ));

    }

    /**
     * Esta clase permite atender los Clicks para las apuestas a favor.
     */
    protected class OnBackBetClickListener implements View.OnClickListener{
        protected Market market;
        protected BigInteger runnerId;

        public OnBackBetClickListener(Market market, BigInteger runnerId){
            super();
            this.market = market;
            this.runnerId = runnerId;
        }

        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            mListener.onBackBetSelected(market, b.getText().toString(), runnerId);
        }
    }

    /**
     * Esta clase permite atender los Clicks para las apuestas EN CONTRA.
     */
    private class OnLayBetClickListener extends OnBackBetClickListener{
        public OnLayBetClickListener(Market market, BigInteger runnerId){
            super(market, runnerId);
        }

        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            mListener.onLayBetSelected(market, b.getText().toString(), runnerId);
        }
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

        public final Button backLocalRunnerButton;
        public final Button layLocalRunnerButton;
        public final Button backDrawRunnerButton;
        public final Button layDrawRunnerButton;
        public final Button backVisitorRunnerButton;
        public final Button layVisitorRunnerButton;

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
            backLocalRunnerButton = view.findViewById(R.id.backLocalRunnerButton);
            layLocalRunnerButton = view.findViewById(R.id.layLocalRunnerButton);
            backDrawRunnerButton = view.findViewById(R.id.backDrawRunnerButton);
            layDrawRunnerButton = view.findViewById(R.id.layDrawRunnerButton);
            backVisitorRunnerButton = view.findViewById(R.id.backVisitorRunnerButton);
            layVisitorRunnerButton = view.findViewById(R.id.layVisitorRunnerButton);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + visitorCompetitorName.getText() + "'";
        }
    }
}
