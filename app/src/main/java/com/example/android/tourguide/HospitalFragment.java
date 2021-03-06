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
 * Use the {@link HospitalFragment} factory method to
 * create an instance of this fragment.
 */
public class HospitalFragment extends Fragment {

    public HospitalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.holycross_name, R.string.holycross_address, R.drawable.hospital1));
        places.add(new Place(R.string.benny_name, R.string.benny_address, R.drawable.hospital2));
        places.add(new Place(R.string.cathedral_name, R.string.cathedral_address, R.drawable.hospital3));
        places.add(new Place(R.string.ogunmoleko_name, R.string.ogunmoleko_address, R.drawable.hospital4));
        places.add(new Place(R.string.fertility_name, R.string.fertility_address, R.drawable.hospital5));
        places.add(new Place(R.string.mother_name, R.string.mother_address, R.drawable.hospital6));
        places.add(new Place(R.string.stmary_name, R.string.stmary_address, R.drawable.hospital7));
        places.add(new Place(R.string.bluecross_name, R.string.bluecross_address, R.drawable.hospital8));
        places.add(new Place(R.string.triple_name, R.string.triple_address, R.drawable.hospital9));
        places.add(new Place(R.string.unique_name, R.string.unique_address, R.drawable.hospital10));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), places, R.color.purple_700);

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