package com.svs.nhatro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.svs.nhatro.base.BaseFragment;
import com.svs.nhatro.others.constant.AppConstant;

import java.util.ArrayList;

/**
 * Created by DangQuang on 4/19/18.
 **/

public class MainAdapter extends FragmentPagerAdapter {

    ArrayList<BaseFragment> fragments = new ArrayList<>();

    public MainAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragments.get(AppConstant.HOME_INDEX);
            case 1:
                return fragments.get(AppConstant.FAVORITE_INDEX);
            case 2:
                return fragments.get(AppConstant.POST_INDEX);
            case 3:
                return fragments.get(AppConstant.MENU_INDEX);
        }
        return null;
    }
}
