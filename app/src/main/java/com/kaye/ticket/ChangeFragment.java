package com.kaye.ticket;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class ChangeFragment {
    public ChangeFragment(Fragment fragment, FragmentManager supportFragmentManager, Integer containerID) {
        supportFragmentManager.beginTransaction()
                .add(containerID,fragment)
                .commit();
    }

    public ChangeFragment(Fragment fragment, FragmentManager supportFragmentManager) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
    }

    public ChangeFragment(Fragment fragment, FragmentManager supportFragmentManager,String tag) {
        supportFragmentManager.beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.container,fragment,tag)
                .commit();
    }
}
