package com.kaye.ticket.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;


public class TicketDialog extends DialogFragment {



    public TicketDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static TicketDialog newInstance(String title, String id, String eventID) {
        TicketDialog frag = new TicketDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("eventID", String.valueOf(eventID));
        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking_dialog, container);
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(1000, 1000);
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        TextView ticketID = view.findViewById(R.id.bookingDialogTicketID);
        ticketID.setText(getArguments().getString("id", "ID"));
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "title");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        Button viewEvents = view.findViewById(R.id.bookingViewEventBtn);
        Window dialog = getDialog().getWindow();

        dialog.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        viewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventID = getArguments().getString("eventID", "0");
                new ChangeFragment(new EventDetail(Integer.valueOf(eventID)), getFragmentManager(),"booking");
                dismiss();
            }
        });
    }
}
