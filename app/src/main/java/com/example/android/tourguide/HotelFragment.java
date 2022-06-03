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

        places.add(new Place(R.string.blessed_name, R.string.blessed_address, R.drawable.hotel1));
        places.add(new Place(R.string.tobisco_name, R.string.tobisco_address, R.drawable.hotel2));
        places.add(new Place(R.string.sheraton_name, R.string.sheraton_address, R.drawable.hotel3));
        places.add(new Place(R.string.eko_name, R.string.eko_name, R.drawable.hotel4));
        places.add(new Place(R.string.lovers_name, R.string.lovers_address, R.drawable.hotel5));
        places.add(new Place(R.string.crossed_name, R.string.crossed_address, R.drawable.hotel6));
        places.add(new Place(R.string.lighthouse_name, R.string.lighthouse_address, R.drawable.hotel7));
        places.add(new Place(R.string.happy_name, R.string.happy_address, R.drawable.hotel8));
        places.add(new Place(R.string.bird_name, R.string.bird_address, R.drawable.hotel9));
        places.add(new Place(R.string.blossom_name, R.string.blossom_address, R.drawable.hotel10));

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