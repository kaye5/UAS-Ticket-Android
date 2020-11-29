package com.kaye.ticket.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.booking.dummy.TicketContent;

public class PaymentDialog extends DialogFragment {



    public PaymentDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static PaymentDialog newInstance(String title, String id) {
        PaymentDialog frag = new PaymentDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payment_fragment, container);
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
        TextView titleText = view.findViewById(R.id.paymentDialogTitle);
        Button payment = view.findViewById(R.id.paymentBtn);
        titleText.setText(getArguments().getString("title", "Enter Name"));
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field

        Window dialog = getDialog().getWindow();

        dialog.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TicketContent.addTicketsBooking(getArguments().getString("id"));
                new ChangeFragment(new Tickets(),getFragmentManager(),"event detail");
                dismiss();
            }
        });
    }
}
