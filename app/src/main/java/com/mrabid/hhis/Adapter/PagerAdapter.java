package com.mrabid.hhis.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Mr.Abid on 6/8/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mrabid.hhis.Fragment.ArtikelFragment;
import com.mrabid.hhis.Fragment.PasienFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PasienFragment tab1 = new PasienFragment();
                return tab1;
            case 1:
                ArtikelFragment tab2 = new ArtikelFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}