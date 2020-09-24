package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.coats.CoatsFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.jacket.JacketsFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.pants.PantsFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.shirts.ShirtsFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.socks.SocksFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.sweaters.SweatersFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.teShirts.TeShirtsFragment;
import com.momoandroid.lebsy.view.activitiesCategory.uiShirts.underWare.UnderWareFragment;

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
                fragment = new CoatsFragment();
                break;
            case 1:
                fragment = new JacketsFragment();
                break;
            case 2:
                fragment = new PantsFragment();
                break;
            case 3:
                fragment = new ShirtsFragment();
                break;
            case 4:
                fragment = new SocksFragment();
                break;
            case 5:
                fragment = new SweatersFragment();
                break;
            case 6:
                fragment = new TeShirtsFragment();
                break;
            case 7:
                fragment = new UnderWareFragment();
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
        // Show 8 total pages.
        return 8;
    }
}