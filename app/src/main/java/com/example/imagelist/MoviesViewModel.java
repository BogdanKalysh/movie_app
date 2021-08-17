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

    public MovieRepository getRepository() {
        return repository;
    }

    public MoviesViewModel() {
        repository = new MovieRepository();
        movieList = repository.getMovieList();
    }

    public void startAutoAdding() {
        repository.startAutoAdding();
    }

    public void stopAutoAdding() {
        repository.stopAutoAdding();
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }
}
