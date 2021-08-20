package com.example.imagelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.imagelist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MoviesViewModel viewModel;
    private RecyclerView movieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        movieRV = findViewById(R.id.activity_main__movie_list);
        movieRV.setLayoutManager(new GridLayoutManager(this,2));
        MoviesAdapter adapter = new MoviesAdapter(viewModel.getRepository());
        movieRV.setAdapter(adapter);

        viewModel.getMovieList().observe(this, movieList -> {
            adapter.setList(movieList);
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onItemRangeInserted(int positionStart, int itemCount) {
                    movieRV.scrollToPosition(positionStart);
                }
            });
        });
    }
}