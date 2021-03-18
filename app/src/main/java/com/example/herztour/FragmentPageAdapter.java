package com.example.herztour;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentPageAdapter extends FragmentPagerAdapter {

    /**
     * Constructor for {@link FragmentPagerAdapter} that sets the fragment manager for the adapter.
     * This is the equivalent of calling {@link #FragmentPagerAdapter(FragmentManager, int)} and
     * passing in {@link #BEHAVIOR_SET_USER_VISIBLE_HINT}.
     *
     * <p>Fragments will have {@link Fragment#setUserVisibleHint(boolean)} called whenever the
     * current Fragment changes.</p>
     *
     * @param fm fragment manager that will interact with this adapter
     * @deprecated use {@link #FragmentPagerAdapter(FragmentManager, int)} with
     * {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT}
     */
    public FragmentPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    // Array of Strings tab captions

    String [] tabCaption = {"Food & Drinks", "Activities", "Sightseeing"};


    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FoodAndDrinksFragment();
        } else if (position == 1) {
            return new ActivitesFragment();
        } else
            return new SightseeingFragment();
    }


    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return tabCaption[position];
        } else if (position == 1) {
            return tabCaption[position];
        } else
            return tabCaption[position];
    }
}
