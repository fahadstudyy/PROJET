package com.example.ssvlvotings;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_Icon = {
            R.drawable.android,
            R.drawable.security,
            R.drawable.sustomservie
    };
    public String[] slide_headings = {
            "Interface",
            "Security",
            "Custom Service"
    };

    public String[] slide_description = {
            "We provide the easiest interface which can be used by anyone. The interface is currently for android users only",
            "Security is our first priority. The app is fully secured and your data will remain secured. We can not access your mobile data in any mean",
            "We provide our customer 24/7 of services"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideImageView =(ImageView)  view.findViewById(R.id.imageView);
        TextView  slideHeading =(TextView) view.findViewById(R.id.heading);
        TextView  slidedescreption =(TextView) view.findViewById(R.id.paragraph);

        slideImageView.setImageResource(slide_Icon[position]);
        slideHeading.setText(slide_headings[position]);
        slidedescreption.setText(slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
