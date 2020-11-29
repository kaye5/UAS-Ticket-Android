package com.kaye.ticket.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;
import com.kaye.ticket.browse.browseFragment;
import com.kaye.ticket.events.dummy.CategoryContent.CategoryDummy;
import com.kaye.ticket.ui.browse;

import java.util.List;
import java.util.Random;

/**
 * {@link RecyclerView.Adapter} that can display a {@link CategoryDummy}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyEventCategoryRecyclerViewAdapter extends RecyclerView.Adapter<MyEventCategoryRecyclerViewAdapter.ViewHolder> {

    private final List<CategoryDummy> mValues;
    int[] gradColor = {R.drawable.grad_1, R.drawable.grad_2, R.drawable.grad_3};

    public MyEventCategoryRecyclerViewAdapter(List<CategoryDummy> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_events_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Random rand = new Random();
        Integer temp = rand.nextInt(3);
        Drawable drawable = ContextCompat.getDrawable(holder.mView.getContext(), gradColor[temp]);
        holder.cardView.setBackground(drawable);
        holder.mContentView.setText(mValues.get(position).content);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ChangeFragment(browse.newInstance(holder.mItem.content), ((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "home");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView mContentView;
        public final LinearLayout cardView;
        public CategoryDummy mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = view.findViewById(R.id.content);
            cardView = view.findViewById(R.id.categoryCardView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}