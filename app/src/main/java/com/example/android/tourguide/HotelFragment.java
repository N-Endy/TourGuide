package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link} factory method to
 * create an instance of this fragment.
 */
public class HotelFragment extends Fragment {

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place("Blessed Inn", "Benson Road", R.drawable.hotel1));
        places.add(new Place("Tobisco Hotel", "Odogunyan, Ikorodu", R.drawable.hotel2));
        places.add(new Place("Sheraton and Suites", "Ikorodu road", R.drawable.hotel3));
        places.add(new Place("Eko Hotel", "Gani Street, Ebute road", R.drawable.hotel4));
        places.add(new Place("Lovers Nest", " Lowa estate", R.drawable.hotel5));
        places.add(new Place("Crossed,", "Bayeku, Ikorodu", R.drawable.hotel6));
        places.add(new Place("The LightHouse", "Ijede Rd, Ijede", R.drawable.hotel7));
        places.add(new Place("Happy Place", "Kola Street, Wera", R.drawable.hotel8));
        places.add(new Place("Bird's Nest", "United Estate, Eyita", R.drawable.hotel9));
        places.add(new Place("Blossom", "Majidun Road, Ogolonto", R.drawable.hotel10));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), places, R.color.teal_200);

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