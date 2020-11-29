package com.kaye.ticket.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.events.dummy.ListEventsContent;
import com.kaye.ticket.ui.EventDetail;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyeventsRecyclerViewAdapter extends RecyclerView.Adapter<MyeventsRecyclerViewAdapter.ViewHolder> {

    private final List<ListEventsContent.EventsDummy> mValues;
    private AdapterView.OnItemClickListener mListener;

    public MyeventsRecyclerViewAdapter(List<ListEventsContent.EventsDummy> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_events_headline, parent, false);

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
        public final CardView card;
        public final ImageView img;
        public ListEventsContent.EventsDummy mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = view.findViewById(R.id.eventsTitle);
            time = view.findViewById(R.id.eventsTime);
            card = view.findViewById(R.id.eventsCard);
            img = view.findViewById(R.id.eventsImage);
        }
    }
}