package com.kaye.ticket.browse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.browse.dummy.DummyContent.DummyItem;
import com.kaye.ticket.events.dummy.ListEventsContent;
import com.kaye.ticket.ui.EventDetail;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MybrowseRecyclerViewAdapter extends RecyclerView.Adapter<MybrowseRecyclerViewAdapter.ViewHolder> {

    private final List<ListEventsContent.EventsDummy> mValues;

    public MybrowseRecyclerViewAdapter(List<ListEventsContent.EventsDummy> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_browse_events, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.title.setText(holder.mItem.getTitle());
        holder.time.setText(holder.mItem.getTime());
        holder.img.setImageResource(holder.mItem.getImg());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                new ChangeFragment(new EventDetail(position), ((AppCompatActivity)context).getSupportFragmentManager(),"events");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title,time;
        public final MaterialCardView card;
        public final ImageView img;
        public ListEventsContent.EventsDummy mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = view.findViewById(R.id.browseTitle);
            time = view.findViewById(R.id.browseDate);
            card = view.findViewById(R.id.browseCard);
            img = view.findViewById(R.id.browseImage);
        }


    }
}