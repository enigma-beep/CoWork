package com.abhigyan.cowork.home;


import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhigyan.cowork.R;

import java.util.ArrayList;
import java.util.List;




public class HomeFragment extends Fragment {

    private List<HomeItem> rv_list;
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.home_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_list = new ArrayList<>();
        rv_list.add(new HomeItem("Home", com.abhigyan.cowork.R.drawable.ic_home_black_24dp));
        rv_list.add(new HomeItem("Dashboard", com.abhigyan.cowork.R.drawable.ic_dashboard));
        rv_list.add(new HomeItem("Notification", R.drawable.ic_notifications));
        rv_list.add(new HomeItem("image", R.drawable.ic_image));
        rv_list.add(new HomeItem("Music video", R.drawable.ic_music_video));
        rv_list.add(new HomeItem("Settings", R.drawable.ic_settings));


        HomeRecyclerAdapter mAdapter = new HomeRecyclerAdapter(rv_list);

        recyclerView.setAdapter(mAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
