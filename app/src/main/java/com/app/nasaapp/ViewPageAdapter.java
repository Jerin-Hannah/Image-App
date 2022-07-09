package com.app.nasaapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

class ViewPageAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> url;
    ArrayList<String> nameList;


    public ViewPageAdapter(Context context, ArrayList<String> url, ArrayList<String> nameList) {

        super();
        this.context = context;
        this.url = url;
        this.nameList = nameList;


    }

    @SuppressLint("NewApi")
    @Override
    public void finishUpdate(ViewGroup container) {
        // TODO Auto-generated method stub
        super.finishUpdate(container);

    }

    @Override
    public int getCount() {

        return url.size();

    }

    @Override
    public boolean isViewFromObject(View collection, Object object) {

        return collection == ((View) object);
    }

    @Override
    public Object instantiateItem(View collection, int position) {

        // Inflating layout
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Setting view you want to display as a row element
        View view = inflater.inflate(R.layout.item, null);

        TextView itemText = (TextView) view.findViewById(R.id.textViewMain);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewmain);

        try {

            itemText.setText(nameList.get(position));
            Picasso.with(context).load(url.get(position)).into(imageView);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ((ViewPager) collection).addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);

    }

}

