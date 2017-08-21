package com.itplace.maria.hw5_fragment;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;
import java.util.Objects;

public class MainActivity extends FragmentActivity {

    static final String TAG = "myLogs";
    static final int PAGE_COUNT = 3;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener   (new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    updateTime((TextView) findViewById(R.id.textView));
                }
                if(position == 1){
                    updateDate((TextView) findViewById(R.id.tvDate));
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //return TimeFragment.newInstance(position);

            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = TimeFragment.newInstance(position);
                break;

                case 1:
                    fragment = DateFragment.newInstance(position);
                break;

                case 2:
                    fragment = ImageFragment.newInstance(position);
                break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }

    public void updateTime (TextView textView){
        //Date date = new Date();
        //Calendar cal = Calendar.getInstance();
        //textView.setText(Objects.toString(System.currentTimeMillis()));

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        textView.setText(formatTime.format(new Date()).toString());

        //textView.setText("time");
    }

    public void updateDate (TextView textView){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        textView.setText(formatDate.format(new Date()));
        //tvDate.setText("date");

        //Date date = new Date();
        //date.getDate();
        //textView.setText(Objects.toString(date.getYear()) + "." +
        //        Objects.toString(date.getMonth())  + "." +
        //        Objects.toString(date.getDay()));
    }

}