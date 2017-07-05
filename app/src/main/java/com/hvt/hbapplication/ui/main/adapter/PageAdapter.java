package com.hvt.hbapplication.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hvt.hbapplication.ui.bookmark.BookmarkFragment;
import com.hvt.hbapplication.ui.home.HomeFragment;
import com.hvt.hbapplication.ui.search.SearchFragment;
import com.hvt.hbapplication.ui.settings.SettingsFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new BookmarkFragment();
            case 3:
                return new SettingsFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
