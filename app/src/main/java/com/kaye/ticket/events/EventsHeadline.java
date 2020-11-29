package com.kaye.ticket.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;

public class EventsHeadline extends Fragment {

    public EventsHeadline() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new ChangeFragment(new EventsFragment(),getFragmentManager(),R.id.listEventHeadlineContainer);
        return inflater.inflate(R.layout.events_headline, container, false);
    }
}