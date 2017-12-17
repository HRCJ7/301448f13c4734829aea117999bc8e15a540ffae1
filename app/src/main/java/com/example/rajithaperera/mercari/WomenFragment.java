package com.example.rajithaperera.mercari;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by rajithaperera on 12/12/17.
 */



public class WomenFragment extends BaseFragment {

    ArrayList<Item> itemList;

    public WomenFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(itemList(getActivity(),"women.json"),getActivity());
        rv.setAdapter(adapter);

        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
        rv.setLayoutManager(llm);

        return rootView;
    }

}
