package com.itplace.maria.hw5_fragment;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backColor;

    static TimeFragment newInstance(int page) {
        TimeFragment pageFragment = new TimeFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        textView.setText(formatTime.format(new Date()).toString());
        
        //tvPage.setText("Page " + pageNumber);

        //Date date = new Date();
        //date.getDate();
        //textView.setText(Objects.toString(date.getTime()));

                //tvPage.setBackgroundColor(backColor);

        //Date date = new Date();
        //date.getDate();
        //SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        //textView.setText(Integer.toString(date.getDate()));

        return view;
    }
}