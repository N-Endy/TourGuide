package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        places.add(new Place(R.string.genius_name, R.string.genius_address, R.drawable.school1));
        places.add(new Place(R.string.landmark_name, R.string.landmark_address, R.drawable.school2));
        places.add(new Place(R.string.lyncrest_name, R.string.lyncrest_address, R.drawable.school3));
        places.add(new Place(R.string.tanzeel_name, R.string.tanzeel_address, R.drawable.school4));
        places.add(new Place(R.string.centcas_name, R.string.centcas_address, R.drawable.school5));
        places.add(new Place(R.string.roosevelt_name, R.string.roosevelt_address, R.drawable.school6));
        places.add(new Place(R.string.lighthouse_name, R.string.lighthouse_address, R.drawable.school7));
        places.add(new Place(R.string.great_name, R.string.great_address, R.drawable.school8));
        places.add(new Place(R.string.primelight_name, R.string.primelight_address, R.drawable.school9));
        places.add(new Place(R.string.blossom_name, R.string.blossom_address, R.drawable.school10));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), places, R.color.purple_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlacesAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the clicked view from the list
                Place item = (Place) listView.getAdapter().getItem(position);

                // Create a new Intent to open activity on Information for clicked view
                Intent informationIntent = new Intent(getActivity(), InformationActivity.class);



                // Individual items from clicked view
                informationIntent.putExtra("name", item.getNameId());
                informationIntent.putExtra("address", item.getAddressId());
                informationIntent.putExtra("image", item.getImageResourceId());
                // Start the new activity
                startActivity(informationIntent);
            }
        });

        return rootView;
    }
}