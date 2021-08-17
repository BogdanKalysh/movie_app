package com.example.imagelist;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {
    private MovieDao movieDao = new MovieDao();
    private LiveData<List<Movie>> movieList = movieDao.getMovieList();

    public void delete(Movie movie) {
        new DeleteMovieAsyncTask(movieDao).execute(movie);
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public void startAutoAdding() {
        movieDao.startAutoAdding();
    }

    public void stopAutoAdding() {movieDao.stopAutoAdding();}

    private static class DeleteMovieAsyncTask extends AsyncTask <Movie, Void, Void>{
        private MovieDao movieDao;

        DeleteMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.delete(movies[0]);
            return null;
        }
    }
}
