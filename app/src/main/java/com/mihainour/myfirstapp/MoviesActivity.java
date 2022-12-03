package com.mihainour.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    // step 0 => add RecyclerView in the xml file & define the item template (matrita)

    // step 1 => get the data source
    // step 1.1 => create a dedicated class for Movie
    // step 1.2 => populate the data source
    private void setMovies() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Home Alone", "Comedy", ""));
        movieList.add(new Movie("Harry Potter", "Fantasy", ""));
        movieList.add(new Movie("Kill Bill", "Action", ""));
        movieList.add(new Movie("Avatar", "SF", ""));
        movieList.add(new Movie("Matrix", "Action", ""));
        movieList.add(new Movie("The Light House", "SF", ""));
        movieList.add(new Movie("Superman", "Action", ""));
        movieList.add(new Movie("Annabel", "Horror", ""));
        movieList.add(new Movie("Spiderman", "Action", ""));
        movieList.add(new Movie("Ironman", "Action", ""));
        movieList.add(new Movie("Lost", "Drama", ""));
    }

    // step 2 => get custom adapter
    // step 2.1 => define the ViewHolder
    // step 2.2 => define the Adapter

    // step 3 => setup adapter for the RecyclerView
    // step 3.1 => setup LayoutManager
    // step 3.2 => set the adapter
}