package com.itplace.maria.hw5_fragment;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import android.graphics.Color;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeFragment extends Fragment {

    static final String ARG_PAGE_TIME = "arg_page_time";

    static TimeFragment newInstance(int page) {
        TimeFragment pageFragment = new TimeFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_TIME, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, null);

        TextView text = (TextView) view.findViewById(R.id.text);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        text.setText(formatTime.format(new Date()).toString());

        return view;
    }
}