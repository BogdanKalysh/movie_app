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
        movieRV.setAdapter(new MoviesAdapter(generateMovieList(16)));
        movieRV.setLayoutManager(new GridLayoutManager(this,2));
    }

    private List<Movie> generateMovieList(int n) {
        List<Movie> movieList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            movieList.add(new Movie("The image number " + i, "https://picsum.photos/id/"+ i +"/200/300"));
        return movieList;
    }
}