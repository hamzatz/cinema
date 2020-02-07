package com.e.cinema.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e.cinema.R;
import com.e.cinema.model.Cinema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView poster;
    private TextView title, desc;
    private String name;


    public MovieViewHolder(@NonNull View itemView) {

        super(itemView);

        poster = itemView.findViewById(R.id.image_view);
        title = itemView.findViewById(R.id.text_title);
        desc = itemView.findViewById(R.id.text_desc);
    }


    public void bind(Cinema cinema) {

        Glide.with(poster.getContext()).load(cinema.getPoster()).into(poster);
        title.setText(cinema.getTitle() + "");
        desc.setText(cinema.getYear());
    }

    private String getDate(String date) {
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = input.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = output.format(d);
        return formatted;
    }
}

