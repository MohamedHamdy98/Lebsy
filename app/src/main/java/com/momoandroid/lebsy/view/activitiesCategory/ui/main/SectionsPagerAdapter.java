package com.momoandroid.lebsy.view.activitiesCategory.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.view.main.ForgotPassFragment;
import com.momoandroid.lebsy.view.main.LogInFragment;
import com.momoandroid.lebsy.view.main.SignUpFragment;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.string.Tshirts, R.string.shirts, R.string.pants, R.string.socks
            , R.string.underware, R.string.jackest, R.string.coats, R.string.sweaters};
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
                fragment = new 1;
                break;
            case 1:
                fragment = new 2;
                break;
            case 2:
                fragment = new 3;
                break;
            case 2:
                fragment = new 4;
                break;
            case 2:
                fragment = new 5;
                break;
            case 2:
                fragment = new 6;
                break;
            case 2:
                fragment = new 7;
                break;
            case 2:
                fragment = new 8;
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
        // Show 2 total pages.
        return 8;
    }
}