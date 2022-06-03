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
        places.add(new Place("Landmark College", "5/11 Olayinka Ogunfile Street", R.drawable.school2));
        places.add(new Place("Lyncrest Schools", "Kayode Shokunbi Street", R.drawable.school3));
        places.add(new Place("At-Tanzeel Schools", "3, Faniyi Street, Ebute road", R.drawable.school4));
        places.add(new Place("Centcas School", " Lowa, 23 Olufunke Mabadeje St", R.drawable.school5));
        places.add(new Place("ROOSEVELT SCHOOLS,", "170, igbogbo Bayeku Road", R.drawable.school6));
        places.add(new Place("LightHouse International School", "Ijede Rd", R.drawable.school7));
        places.add(new Place("Great Joy Schools", "13/15 Sola Kola Street", R.drawable.school8));
        places.add(new Place("The Primelight Schools", "Francis Onajinrin St", R.drawable.school9));
        places.add(new Place("Unique Blossom School", "1 Ikorodu-Ososun Rd", R.drawable.school10));

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