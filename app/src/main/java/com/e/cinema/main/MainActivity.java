package com.e.cinema.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.cinema.R;
import com.e.cinema.adapter.MovieAdapter;
import com.e.cinema.adapter.MovieViewHolder;
import com.e.cinema.model.Cinema;
import com.e.cinema.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.e.cinema.BuildConfig.CINEMA_KEY;

public class MainActivity extends AppCompatActivity {

    MovieAdapter adapter;
    List<Cinema> list = new ArrayList<>();
    Button btnsearch;
    public static EditText edtext;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMovie();

            }
        });


    }

    private void initView(){

        RecyclerView recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        btnsearch = findViewById(R.id.bottom_s);
        edtext= findViewById(R.id.ed_search);
    }

    private void showMovie(){

        RetrofitBuilder.getService().getFilms(edtext.getText().toString(), CINEMA_KEY).enqueue(new Callback<Cinema>() {
            @Override
            public void onResponse(Call<Cinema> call, Response<Cinema> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        response.body().getTitle();
                    }
                }
                Log.e("-------m", response.body().getTitle()+"");
                list.add(response.body());
                adapter.setNews(list);
            }

            @Override
            public void onFailure(Call<Cinema> call, Throwable t) {

            }
        });
    }


}
