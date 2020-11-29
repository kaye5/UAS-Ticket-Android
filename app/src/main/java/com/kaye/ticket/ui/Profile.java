package com.kaye.ticket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.booking.dummy.TicketContent;

import java.util.ArrayList;

public class Profile extends Fragment {

    private Button saveChange;
    private ArrayList<EditText> Input = new ArrayList<EditText>();
    private TextView tCount,tv_address;
    private ImageView settings;

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Input.add(view.findViewById(R.id.profileEmail));
        Input.add(view.findViewById(R.id.profilePhone));
        Input.add(view.findViewById(R.id.profileAddress));
        settings = view.findViewById(R.id.profileEditBtn);
        saveChange = view.findViewById(R.id.profileSaveChange);
        tv_address = view.findViewById(R.id.tv_address);
        tCount = view.findViewById(R.id.ticketsCount);
        tCount.setText(String.valueOf(TicketContent.ITEMS.size()));
        RelativeLayout tickets = view.findViewById(R.id.profileTickets);

        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ChangeFragment(new Tickets(),getFragmentManager(),"profile");
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChange.setVisibility(View.VISIBLE);
                for(EditText el : Input){
                    el.setFocusableInTouchMode(true);
                    System.out.println(el.getText().toString());
                }
            }
        });

        saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChange.setVisibility(View.INVISIBLE);
                EditText addE = Input.get(2);
                String address = addE.getText().toString();
                Log.i("add",address);
                tv_address.setText(address);
                for(EditText el : Input){
                    el.setFocusable(false);
                }
            }
        });

        return view;
    }


}