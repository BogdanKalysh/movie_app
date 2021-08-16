package com.example.imagelist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    private MovieRepository repository;
    private LiveData<List<Movie>> movieList;

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public MoviesViewModel() {
        repository = new MovieRepository();
        movieList = repository.getMovieList();
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }
}
