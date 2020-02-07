package com.e.cinema.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.cinema.R;
import com.e.cinema.main.MainActivity;
import com.e.cinema.model.Cinema;

import java.util.ArrayList;
import java.util.List;

   public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {


    private List<Cinema> newsList = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setNews(List<Cinema> movie){
        newsList.clear();
        newsList.addAll(movie);
        notifyDataSetChanged();

    }
}
