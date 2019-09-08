package ar.com.betex.betexmobile.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.betex.betexmobile.R;

import ar.com.betex.betexmobile.fragments.dummy.DummyContent.DummyItem;
import ar.com.betex.betexmobile.fragments.listener.OnP2PBetFragmentInteractionListener;

import java.util.List;

/**
 * Es un adapter para mostrar la un elemento de la lista de apuestas p2p.
 * @author Diego Mernies
 */
public class P2pBetItemRecyclerViewAdapter extends RecyclerView.Adapter<P2pBetItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnP2PBetFragmentInteractionListener mListener;

    public P2pBetItemRecyclerViewAdapter(List<DummyItem> items, OnP2PBetFragmentInteractionListener listener) {
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
        holder.mItem = mValues.get(position);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                   // mListener.onP2PBetAccepted(holder.mItem);
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
        public DummyItem mItem;

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
        public ImageView eventTypeImage;


        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }
}
