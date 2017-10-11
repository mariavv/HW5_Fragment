package com.itplace.maria.hw5_fragment;


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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MainActivity extends FragmentActivity {

    static final int PAGE_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    updateTime((TextView) findViewById(R.id.text));
                }
                if (position == 1) {
                    updateDate((TextView) findViewById(R.id.text));
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

        @Override
        public CharSequence getPageTitle(int position) {
            String s = "";
            switch (position) {
                case 0:
                    s = getString(R.string.time);
                    break;

                case 1:
                    s = getString(R.string.date);
                    break;

                case 2:
                    s = getString(R.string.pic);
                    break;
            }
            return s;
        }
    }

    public void updateTime(TextView textView) {
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        textView.setText(formatTime.format(new Date()).toString());
    }

    public void updateDate(TextView textView) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        textView.setText(formatDate.format(new Date()));
    }

}