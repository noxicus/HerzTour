package com.example.herztour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
 * Use the {@link FoodAndDrinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodAndDrinksFragment extends Fragment {

    MediaPlayer mMediaPlayer;

    AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMedia();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMedia();
        }
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodAndDrinksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodAndDrinksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodAndDrinksFragment newInstance(String param1, String param2) {
        FoodAndDrinksFragment fragment = new FoodAndDrinksFragment();
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
        View rootView =  inflater.inflate(R.layout.location_list, container, false);

        // Gets system service for audio playback
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Create ArrayList of Location objects
        ArrayList<Location> foodAndDrinks = new ArrayList<Location>();

        // Initializing List with data

        foodAndDrinks.add(new Location("Del Rio", "Kardinala Stepinca 12, Mostar ", R.drawable.delrio, "Restaurant", R.raw.delrio));
        foodAndDrinks.add(new Location("Mali Puž", "Kralja Tomislava 5, Mostar ", R.drawable.malipuz, "Pub", R.raw.malipuz));
        foodAndDrinks.add(new Location("Del Rio", "Kardinala Stepinca 12, Mostar ", R.drawable.delrio, "Restaurant", R.raw.delrio));
        foodAndDrinks.add(new Location("Mali Puž", "Kralja Tomislava 5, Mostar ", R.drawable.malipuz, "Pub", R.raw.malipuz));
        foodAndDrinks.add(new Location("Del Rio", "Kardinala Stepinca 12, Mostar ", R.drawable.delrio, "Restaurant", R.raw.delrio));
        foodAndDrinks.add(new Location("Mali Puž", "Kralja Tomislava 5, Mostar ", R.drawable.malipuz, "Pub", R.raw.malipuz));
        foodAndDrinks.add(new Location("Del Rio", "Kardinala Stepinca 12, Mostar ", R.drawable.delrio, "Restaurant", R.raw.delrio));
        foodAndDrinks.add(new Location("Mali Puž", "Kralja Tomislava 5, Mostar ", R.drawable.malipuz, "Pub", R.raw.malipuz));

        @SuppressLint("ResourceType")
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), foodAndDrinks, R.color.yellow);

        ListView listView = (ListView) rootView.findViewById(R.id.list_of_items);

        listView.setAdapter(locationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMedia();

                Location location = foodAndDrinks.get(position);

                mMediaPlayer = MediaPlayer.create(getActivity(), location.getSound());

                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer.start();
                }

                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMedia();
    }

    private void releaseMedia() {
        if (mMediaPlayer != null) {

            // Releases media player if contains any audio
            mMediaPlayer.release();

            mMediaPlayer = null;
            // Abandon audio focus
            mAudioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
