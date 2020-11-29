package com.kaye.ticket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.booking.TicketsFragment;

public class Tickets extends Fragment {


    public Tickets() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new ChangeFragment(new TicketsFragment(),getFragmentManager(),R.id.ticketsList);
        return inflater.inflate(R.layout.fragment_ticket_container, container, false);
    }
}