package com.itplace.maria.hw5_fragment;

import android.content.Context;
import android.graphics.Color;
import java.text.SimpleDateFormat;
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

    static final String ARG_PAGE_DATE = "arg_page_date";

    static DateFragment newInstance(int page) {
        DateFragment pageFragment = new DateFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_DATE, page);
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
        View view = inflater.inflate(R.layout.fragment_date, null);

        TextView text = (TextView) view.findViewById(R.id.text);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        text.setText(formatDate.format(new Date()));

        return view;
    }
}