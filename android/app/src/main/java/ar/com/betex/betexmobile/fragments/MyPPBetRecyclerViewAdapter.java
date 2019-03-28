package ar.com.betex.betexmobile.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.betex.betexmobile.R;

import ar.com.betex.betexmobile.fragments.dummy.DummyContent.DummyItem;
import ar.com.betex.betexmobile.fragments.listener.OnP2PBetFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnP2PBetFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPPBetRecyclerViewAdapter extends RecyclerView.Adapter<MyPPBetRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnP2PBetFragmentInteractionListener mListener;

    public MyPPBetRecyclerViewAdapter(List<DummyItem> items, OnP2PBetFragmentInteractionListener listener) {
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

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }
}
