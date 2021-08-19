package com.example.imagelist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    private MovieRepository repository;
    private AutoImageAdder autoAdder;
    private LiveData<List<Movie>> movieList;

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public MovieRepository getRepository() {
        return repository;
    }

    public MoviesViewModel() {
        repository = new MovieRepository();
        autoAdder = new AutoImageAdder();
        movieList = repository.getMovieList();
    }

    public void startAutoAdding() {
        autoAdder.startAutoAdding();
    }

    public void stopAutoAdding() {
        autoAdder.stopAutoAdding();
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }
}
