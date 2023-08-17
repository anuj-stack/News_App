package com.whatsapp.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, msports, mhealth, mscience, mtech, mentertain;
    PagerAdapter adapter;
    Toolbar toolbar;

    String api = "2385c2f3e2574a4b9918c11029c93334";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("News Feed");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        mhome = findViewById(R.id.home);
        mhealth = findViewById(R.id.health);
        mentertain = findViewById(R.id.entertainment);
        mscience = findViewById(R.id.science);
        msports = findViewById(R.id.sports);
        mtech = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        adapter = new PagerAdapter(getSupportFragmentManager() , 6);
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5){
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}