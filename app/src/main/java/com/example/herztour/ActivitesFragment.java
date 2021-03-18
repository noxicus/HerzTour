package com.example.herztour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivitesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivitesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivitesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivitesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivitesFragment newInstance(String param1, String param2) {
        ActivitesFragment fragment = new ActivitesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Creates array of activities
        ArrayList<Location> activities = new ArrayList<>();

        // Ading Location objects in array
        activities.add(new Location("Paragliding", "Planinica bb, Mostar", R.drawable.paragliding, "Paragliding"));
        activities.add(new Location("Rafting", "Konjic bb", R.drawable.rafting, "Rafting"));
        activities.add(new Location("Paragliding", "Planinica bb, Mostar", R.drawable.paragliding, "Paragliding"));
        activities.add(new Location("Rafting", "Konjic bb", R.drawable.rafting, "Rafting"));
        activities.add(new Location("Paragliding", "Planinica bb, Mostar", R.drawable.paragliding, "Paragliding"));
        activities.add(new Location("Rafting", "Konjic bb", R.drawable.rafting, "Rafting"));
        activities.add(new Location("Paragliding", "Planinica bb, Mostar", R.drawable.paragliding, "Paragliding"));
        activities.add(new Location("Rafting", "Konjic bb", R.drawable.rafting, "Rafting"));

        // Creating instance of Location adapter
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), activities, R.color.green);

        // finds list view by id
        ListView listView = (ListView) rootView.findViewById(R.id.list_of_items);

        // Sets adapter on list view
        listView.setAdapter(locationAdapter);
        return rootView;
    }
}