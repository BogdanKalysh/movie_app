package com.example.imagelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MoviesViewModel viewModel;
    private RecyclerView movieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MoviesViewModel.class);

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

        AppCompatCheckBox autoAddCheckbox = (AppCompatCheckBox) findViewById(R.id.activity_main__auto_add_checkbox);
        viewModel.getAutoAddingState().observe(this, autoAddingState -> {
            autoAddCheckbox.setChecked(autoAddingState);
        });

        autoAddCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                viewModel.setAutoAddingState(autoAddCheckbox.isChecked());
            }
        });
    }
}