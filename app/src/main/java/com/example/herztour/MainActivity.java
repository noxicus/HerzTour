package com.example.herztour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(fragmentPagerAdapter);

    }
}