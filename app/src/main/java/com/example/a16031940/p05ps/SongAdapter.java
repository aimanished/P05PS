package com.example.a16031940.p05ps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private ArrayList<Song> song ;
    private Context context;
    private TextView tvSinger,tvTitle,tvYear,tvStar;
    private ImageView imgSong;

    public SongAdapter(Context context,int resource,ArrayList<Song> objects){
        super(context,resource,objects);
        song = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row,parent,false);
        tvSinger = rowView.findViewById(R.id.singer);
        tvStar = rowView.findViewById(R.id.star);
        tvTitle = rowView.findViewById(R.id.title);
        tvYear = rowView.findViewById(R.id.year);
        imgSong = rowView.findViewById(R.id.imageView);

        Song currentSong = song.get(position);

        tvYear.setText(currentSong.getSingers());
        tvTitle.setText(currentSong.getTitle());
        tvStar.setText(currentSong.getStars());
        tvSinger.setText(currentSong.getSingers());
        // if else here for star


        return rowView;

    }
}
