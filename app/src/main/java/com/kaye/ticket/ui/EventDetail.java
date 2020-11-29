package com.kaye.ticket.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.booking.dummy.TicketContent;
import com.kaye.ticket.events.dummy.ListEventsContent;

public class EventDetail extends Fragment {


    private TextView title,time,description;
    private ImageView img;
    private Button book;
    private ListEventsContent.EventsDummy mEvent;
    public EventDetail(int position) {
       this.mEvent = ListEventsContent.ITEMS.get(position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
        title = view.findViewById(R.id.eventDetailTitle);
        description = view.findViewById(R.id.eventDetailDescription);
        time = view.findViewById(R.id.eventDetailTime);
        book = view.findViewById(R.id.eventDetailBookBtn);
        img = view.findViewById(R.id.eventDetailImage);
        title.setText(mEvent.getTitle());
        time.setText(mEvent.getTime());
        description.setText(mEvent.getDescription());
        img.setImageResource(mEvent.getImg());

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                PaymentDialog payment =  PaymentDialog.newInstance(mEvent.getTitle(),mEvent.getID());
                payment.show(fm,"payment");
//                TicketContent.addTicketsBooking(mEvent.getID());
//                new ChangeFragment(new Tickets(),getFragmentManager(),"event detail");
            }
        });

        return view;
    }
}