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
 * Use the {@link SightseeingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SightseeingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SightseeingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SightseeingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SightseeingFragment newInstance(String param1, String param2) {
        SightseeingFragment fragment = new SightseeingFragment();
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

        ArrayList<Location> locationArrayList = new ArrayList<Location>();

        locationArrayList.add(new Location("Old Bridge", "Stari most, Mostar", R.drawable.oldbridge));
        locationArrayList.add(new Location("Herceg Stjepan Kosaca", "STrg hrvatskih velikana bb, Mostar", R.drawable.kosaca));
        locationArrayList.add(new Location("Old Bridge", "Stari most, Mostar", R.drawable.oldbridge));
        locationArrayList.add(new Location("Herceg Stjepan Kosaca", "STrg hrvatskih velikana bb, Mostar", R.drawable.kosaca));
        locationArrayList.add(new Location("Old Bridge", "Stari most, Mostar", R.drawable.oldbridge));
        locationArrayList.add(new Location("Herceg Stjepan Kosaca", "STrg hrvatskih velikana bb, Mostar", R.drawable.kosaca));
        locationArrayList.add(new Location("Old Bridge", "Stari most, Mostar", R.drawable.oldbridge));
        locationArrayList.add(new Location("Herceg Stjepan Kosaca", "STrg hrvatskih velikana bb, Mostar", R.drawable.kosaca));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locationArrayList, R.color.red);

        ListView listView = (ListView) rootView.findViewById(R.id.list_of_items);

        listView.setAdapter(locationAdapter);
        return rootView;
    }
}