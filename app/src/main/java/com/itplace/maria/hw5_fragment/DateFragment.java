package com.itplace.maria.hw5_fragment;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.Objects;
import java.util.Random;



public class DateFragment extends Fragment {

    static final String ARG_DATE = "arg_date";

    int pageNumber;

    static DateFragment newInstance(int page) {
        DateFragment pageFragment = new DateFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_DATE, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARG_DATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, null);

        TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        tvDate.setText(formatDate.format(new Date()));
        //tvDate.setText("Page " + pageNumber);

        Date date = new Date();
        date.getDate();
        tvDate.setText(Objects.toString(date.getTime()));

        //tvPage.setBackgroundColor(backColor);

        //Date date = new Date();
        //date.getDate();
        //SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        //textView.setText(Integer.toString(date.getDate()));

        return view;
    }
}