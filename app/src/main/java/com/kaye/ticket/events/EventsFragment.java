package com.kaye.ticket.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.R;
import com.kaye.ticket.events.dummy.ListEventsContent;

/**
 * A fragment representing a list of Items.
 */
public class EventsFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventsFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_headline_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL,false);
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new MyeventsRecyclerViewAdapter(ListEventsContent.ITEMS));
        }
        return view;
    }
}