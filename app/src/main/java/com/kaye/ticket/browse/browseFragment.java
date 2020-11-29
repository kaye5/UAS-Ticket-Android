package com.kaye.ticket.browse;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.R;
import com.kaye.ticket.browse.dummy.DummyContent;
import com.kaye.ticket.events.dummy.ListEventsContent;

/**
 * A fragment representing a list of Items.
 */
public class browseFragment extends Fragment {

    public browseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse_list, container, false);


        RecyclerView recyclerView = (RecyclerView) view;

        recyclerView.setAdapter(new MybrowseRecyclerViewAdapter(ListEventsContent.ITEMS));
        return view;
    }
}