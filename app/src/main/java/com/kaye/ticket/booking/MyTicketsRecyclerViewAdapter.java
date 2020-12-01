package com.kaye.ticket.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.kaye.ticket.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaye.ticket.booking.dummy.TicketContent.TicketDummyItem;
import com.kaye.ticket.events.dummy.ListEventsContent;
import com.kaye.ticket.ui.TicketDialog;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link TicketDummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTicketsRecyclerViewAdapter extends RecyclerView.Adapter<MyTicketsRecyclerViewAdapter.ViewHolder> {

    private final List<TicketDummyItem> mValues;

    public MyTicketsRecyclerViewAdapter(List<TicketDummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tickets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        ListEventsContent.EventsDummy mEvents = ListEventsContent.ITEMS.get(Integer.parseInt(holder.mItem.eventID));
        holder.ticketTitle.setText(mEvents.getTitle());
        holder.eventDate.setText(mEvents.getTime());
        holder.img.setImageResource(mEvents.getImg());
        holder.regisDate.setText(holder.mItem.getRegisDate());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((AppCompatActivity)v.getContext()).getSupportFragmentManager();
                TicketDialog payment =  TicketDialog.newInstance(mEvents.getTitle(),holder.mItem.getTicketID(),mEvents.getEventID());
                payment.show(fm,"booking");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView ticketTitle,eventDate,regisDate;
        public final ImageView img;
        public final MaterialCardView card;
        public TicketDummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            card = view.findViewById(R.id.ticketCard);
            ticketTitle = view.findViewById(R.id.ticketTitle);
            eventDate = view.findViewById(R.id.ticketEventDate);
            regisDate = view.findViewById(R.id.ticketBookDate);
            img = view.findViewById(R.id.ticketImage);
        }
    }
}