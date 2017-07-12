package com.hvt.hbapplication.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hvt.hbapplication.ui.bookmark.BookmarkFragment;
import com.hvt.hbapplication.ui.home.HomeFragment;
import com.hvt.hbapplication.ui.search.SearchFragment;
import com.hvt.hbapplication.ui.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SearchFragment());
        fragments.add(new BookmarkFragment());
        fragments.add(new SettingsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
