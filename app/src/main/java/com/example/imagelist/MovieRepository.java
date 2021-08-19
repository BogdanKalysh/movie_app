package com.example.imagelist;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {
    private MovieDao movieDao = MovieDao.getInstance();
    private LiveData<List<Movie>> movieList = movieDao.getMovieList();

    public void delete(Movie movie) {
        movieDao.delete(movie);
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }
}
