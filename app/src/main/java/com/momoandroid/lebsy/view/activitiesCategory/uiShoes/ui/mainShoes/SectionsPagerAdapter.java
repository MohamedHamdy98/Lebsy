package com.momoandroid.lebsy.view.activitiesCategory.uiShoes.ui.mainShoes;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.view.activitiesCategory.uiShoes.childrenShoe.ChildrenFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShoes.manShoe.ManShoesFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShoes.womanShoe.WomanShoesFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.string.children, R.string.man,R.string.woman};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ChildrenFragment();
                break;
            case 1:
                fragment =  new ManShoesFragment();
                break;
            case 2:
                fragment = new WomanShoesFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}