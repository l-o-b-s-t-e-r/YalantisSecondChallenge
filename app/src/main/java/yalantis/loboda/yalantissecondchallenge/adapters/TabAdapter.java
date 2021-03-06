package yalantis.loboda.yalantissecondchallenge.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import yalantis.loboda.yalantissecondchallenge.activities.MainActivity;

/**
 * Created by macos on 10.04.16.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public TabAdapter(FragmentManager fragmentManager, List<Fragment> fragments){
        super(fragmentManager);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getArguments().getString(MainActivity.TITLE);
    }

}
