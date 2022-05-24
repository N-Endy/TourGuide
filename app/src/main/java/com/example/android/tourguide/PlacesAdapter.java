package com.example.android.tourguide;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * {@link PlacesAdapter} is a {@link androidx.fragment.app.FragmentPagerAdapter}
 * that can provide the layout of each list item
 */
public class PlacesAdapter extends FragmentPagerAdapter {

    /**
     * Create a new {@link PlacesAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public PlacesAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new SchoolFragment();
        } else if (position == 1) {
            return new FastFoodFragment();
        } else if (position == 3) {
            return new HospitalFragment();
        } else {
            return new ChurchFragment();
        }
    }

    /**
     *
     * @return total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
