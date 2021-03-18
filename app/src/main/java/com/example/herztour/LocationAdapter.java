package com.example.herztour;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class LocationAdapter extends ArrayAdapter<Location> {

    int mColor = 0;

    public LocationAdapter(@NonNull Context context, @NonNull List<Location> objects, int mColor) {
        super(context, 0, objects);
        this.mColor = mColor;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Location location = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_image);
        imageView.setImageResource(location.getImageResourceId());

        TextView textView1 = (TextView) convertView.findViewById(R.id.item_type);

        if (location.isType()) {
            textView1.setVisibility(View.VISIBLE);
            textView1.setText(location.getTypeOfLocation());
        } else {
            textView1.setVisibility(View.GONE);
        }

        TextView textView2 = (TextView) convertView.findViewById(R.id.item_name);
        textView2.setText(location.getName());

        TextView textView3 = (TextView) convertView.findViewById(R.id.item_address);
        textView3.setText(location.getAddress());

        View container = (View) convertView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColor);
        container.setBackgroundColor(color);

        return convertView;
    }
}
