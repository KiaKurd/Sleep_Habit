package com.example.sleephabit.navigator.homeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sleephabit.R;
import com.example.sleephabit.model.Tag;
import com.example.sleephabit.model.TipsDescription;
import com.example.sleephabit.navigator.BottomNav;
import com.example.sleephabit.retrofit.RetrofitService;
import com.example.sleephabit.retrofit.TagApi;
import com.example.sleephabit.retrofit.TipsDescriptionApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment {
     RecyclerView recyclerView;
     BottomNav bottomNav;
    public HomeFragment() {
        // require a empty public constructor
         }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        recyclerView = recyclerView.findViewById(R.id.card_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(bottomNav));




        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    //Loading TipsDescription from server and Sending data to recycler view
    private void loadTipsDescription() {
        RetrofitService retrofit = new RetrofitService();
        TipsDescriptionApi tipsDescriptionApi = retrofit.getRetrofit().create(TipsDescriptionApi.class);
        tipsDescriptionApi.getAllTips().enqueue(new Callback<List<TipsDescription>>(){
            @Override
            public void onResponse(Call<List<TipsDescription>> call, Response<List<TipsDescription>> response) {
                populateTipsDescriptionView(response.body());
            }

            @Override
            public void onFailure(Call<List<TipsDescription>> call, Throwable t) {
                Toast.makeText(HomeFragment.this, "Failed to load Tips", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateTipsDescriptionView(List<TipsDescription> tipsDescriptionsList) {
        TipAdapter tipAdapter = new TipAdapter(null ,tipsDescriptionsList);
        recyclerView.setAdapter(tipAdapter);
    }


    //Loading Tag from server and Sending data to recycler view
    private void loadTag() {
        RetrofitService retrofit = new RetrofitService();
        TagApi tagApi = retrofit.getRetrofit().create(TagApi.class);
        tagApi.getAllTags().enqueue(new Callback<List<Tag>>(){
            @Override
            public void onResponse(Call<List<Tag>> call, Response<List<Tag>> response) {
                populateTagView(response.body());
            }

            @Override
            public void onFailure(Call<List<Tag>> call, Throwable t) {
                Toast.makeText(HomeFragment.this, "Failed to load Tags", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateTagView(List<Tag> tagList) {
        TipAdapter tipAdapter = new TipAdapter(tagList, null);
        recyclerView.setAdapter(tipAdapter);
    }



    @Override
    public void onResume() {
        super.onResume();
        loadTipsDescription();
        loadTag();
    }
}