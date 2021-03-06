package com.itplace.maria.hw5_fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;



public class ImageFragment extends Fragment {

    static final String ARG_PAGE_IMAGE = "arg_page_image";

    static ImageFragment newInstance(int page) {
        ImageFragment pageFragment = new ImageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_IMAGE, page);
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
        View view = inflater.inflate(R.layout.fragment_image, null);
        return view;
    }
}