package com.kaye.ticket.events;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaye.ticket.R;
import com.kaye.ticket.events.dummy.CategoryContent;

/**
 * A fragment representing a list of Items.
 */
public class EventCategoryFragment extends Fragment {



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventCategoryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,2);
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(new MyEventCategoryRecyclerViewAdapter(CategoryContent.ITEMS));
        }
        return view;
    }
}