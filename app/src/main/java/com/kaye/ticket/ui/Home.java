package com.kaye.ticket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.events.EventCategoryFragment;
import com.kaye.ticket.events.EventsHeadline;

public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new ChangeFragment(new EventsHeadline(),getFragmentManager(),R.id.eventHeadlineContainer);
        new ChangeFragment(new EventCategoryFragment(),getFragmentManager(),R.id.eventCategory);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}