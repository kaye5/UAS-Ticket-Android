package com.kaye.ticket.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kaye.ticket.ChangeFragment;
import com.kaye.ticket.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ChangeFragment(new Home(),getSupportFragmentManager(),"home");
        footer = findViewById(R.id.bottom_navigation);
        footer.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment = new Home();
                break;
            case R.id.navigation_profile:
                fragment = new Profile();
                break;
            case R.id.navigation_tickets:
                fragment = new Tickets();
                break;
        }
        new ChangeFragment(fragment,getSupportFragmentManager(),"home");
        return true;
    }
}