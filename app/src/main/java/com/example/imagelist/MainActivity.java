package com.example.imagelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView movieRV = findViewById(R.id.activity_main__movie_list);
        movies = generateMovieList();
        movieRV.setAdapter(new MoviesAdapter(movies));
        movieRV.setLayoutManager(new GridLayoutManager(this,2));
    }

    private List<Movie> generateMovieList() {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));
        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));
        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));
        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));
        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));
        movieList.add(new Movie("The great movie number one", R.drawable.icon));
        movieList.add(new Movie("A little bit less interesting movie", R.drawable.icon));
        movieList.add(new Movie("Kinda ok movie to watch", R.drawable.icon));

        return movieList;
    }
}