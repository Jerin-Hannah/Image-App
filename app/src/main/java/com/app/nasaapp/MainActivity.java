package com.app.nasaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;

    int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};


    ArrayList<String> urls= new ArrayList<>();
    ArrayList<String> nameList= new ArrayList<>();
    ArrayList<String> dateList= new ArrayList<>();
    ArrayList<String> explanationList= new ArrayList<>();
    ArrayList<String> copyRightList= new ArrayList<>();
    ArrayList<String> mediaList= new ArrayList<>();
    ArrayList<String> serviceVersionList= new ArrayList<>();

    ViewPageAdapter mViewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "data.json");
        Log.i("data", jsonFileString);
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<GetData>>() { }.getType();
        List<GetData> users = gson.fromJson(jsonFileString, listUserType);
        for (int i = 0; i < users.size(); i++) {
            // Log.i("data", "> Item " + i + "\n" + users.get(i));
            String datee= users.get(i).getDate();
            users.get(i).getExplanation();
            String url =users.get(i).getUrl();
            String title=users.get(i).getTitle();
            String description=users.get(i).getExplanation();
            String copyRight=users.get(i).getCopyright();
            String mediaType=users.get(i).getMediaType();
            String serviceVersion=users.get(i).getServiceVersion();
            urls.add(url);
            nameList.add(title);
            dateList.add(datee);
            mediaList.add(mediaType);
            copyRightList.add(copyRight);
            explanationList.add(description);
            serviceVersionList.add(serviceVersion);
        }

        setContentView(R.layout.activity_main);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewpager1);

        // Initializing the ViewPagerAdapter
        mViewPageAdapter = new ViewPageAdapter(MainActivity.this, urls, nameList, explanationList, dateList, copyRightList, mediaList, serviceVersionList);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPageAdapter);
    }
}