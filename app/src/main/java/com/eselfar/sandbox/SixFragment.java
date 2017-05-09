package com.eselfar.sandbox;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SixFragment extends Fragment {

    private static final String ARGS_URLS = "bundle_urls";
    private ArrayList<String> mUrls;
    private ArrayAdapter<String> mAdapter;

    public SixFragment() {
        // Required empty public constructor
    }

    /**
     * @param urls ArrayList of url_pdf
     * @return A new instance of the {@link SixFragment}
     */
    public static SixFragment newInstance(ArrayList<String> urls) {

        Bundle args = new Bundle();
        // put the array into the fragment arguments bundle
        args.putStringArrayList(ARGS_URLS, urls);

        SixFragment fragment = new SixFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve data from the Fragment's arguments
        mUrls = getArguments().getStringArrayList(ARGS_URLS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_six, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);

        // Use an ArrayAdapter instead of the SimpleAdapter as it automatically manage a List
        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mUrls);
        listView.setAdapter(mAdapter);

        return view;
    }

}
