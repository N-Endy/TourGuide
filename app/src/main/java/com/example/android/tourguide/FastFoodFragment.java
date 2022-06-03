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
 * Use the {@link FastFoodFragment} factory method to
 * create an instance of this fragment.
 */
public class FastFoodFragment extends Fragment {

    public FastFoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place("Cheesy Feel", "Eyita Estate", R.drawable.food1));
        places.add(new Place("Chinese Restaurante", "Agric, Ikorodu", R.drawable.food2));
        places.add(new Place("KFC", "14, Shorodoye Street", R.drawable.food10));
        places.add(new Place("Kiddies Choice", "Ebute road", R.drawable.food3));
        places.add(new Place("Lacebo", "Placebo Palace, Ijede", R.drawable.food4));
        places.add(new Place("Mr Biggs", "Igbogbo Bayeku Road", R.drawable.food6));
        places.add(new Place("Tantalizers", "Ikorodu Rd", R.drawable.food7));
        places.add(new Place("Tastee Fried", "1 Benson Bustop", R.drawable.food8));
        places.add(new Place("The Place", "Francis Onajinrin St", R.drawable.food9));
        places.add(new Place("Yummy Yummy", "1 Ikorodu-Ososun Rd", R.drawable.food5));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), places, R.color.teal_700);

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