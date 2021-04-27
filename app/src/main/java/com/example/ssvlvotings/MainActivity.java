package com.example.ssvlvotings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSlideViewPage;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    private SliderAdapter slideradapter;

    private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mSlideViewPage =findViewById(R.id.viewer);
        mDotLayout = findViewById(R.id.dots);

        slideradapter = new SliderAdapter(this);
        mSlideViewPage.setAdapter(slideradapter);
        addDotsIndicator(0);

        mSlideViewPage.addOnPageChangeListener(viewListner);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        for(int i = 0; i < mDots.length; i++)
        {
            mDots[i] = new  TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(30);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

             mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.white));

        }
    }
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}