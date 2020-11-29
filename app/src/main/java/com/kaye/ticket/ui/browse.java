package com.kaye.ticket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.browse.browseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link browse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class browse extends Fragment {
    String name;
    public browse() {
        // Required empty public constructor
    }

    public static browse newInstance(String name) {
        browse fragment = new browse();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse, container, false);
        TextView browseTitle = view.findViewById(R.id.browseHeader);
        browseTitle.setText(name);
        new ChangeFragment(new browseFragment(),getFragmentManager(),R.id.browseEventsListContainer);
        return view;
    }
}