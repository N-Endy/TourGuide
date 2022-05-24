package com.example.android.tourguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * It displays a list of Schools in locality
 */
public class SchoolFragment extends Fragment {

    public SchoolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));
        places.add(new Place(R.string.school_genius, R.string.address_genius, R.drawable.cover1));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), places, R.color.purple_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlacesAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}