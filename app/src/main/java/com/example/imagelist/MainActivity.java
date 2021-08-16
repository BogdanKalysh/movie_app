package com.example.imagelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MoviesViewModel viewModel;
    private RecyclerView movieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRV = findViewById(R.id.activity_main__movie_list);
        movieRV.setLayoutManager(new GridLayoutManager(this,2));
        final MoviesAdapter adapter = new MoviesAdapter();
        movieRV.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        viewModel.getMovieList().observe(this, movieList -> {
            adapter.setMovieList(movieList);
        });

    }
}