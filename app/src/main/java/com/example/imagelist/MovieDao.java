package com.example.imagelist;

import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    private static MovieDao instance;
    private final MutableLiveData<List<Movie>> movieList;
    private int numOfMovie;
    private final CountDownTimer timer = new CountDownTimer(5000, 1) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            List<Movie> tmpMovies = movieList.getValue();
            tmpMovies.add(generateMovie());
            movieList.setValue(tmpMovies);

            start();
        }
    };

    public MutableLiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public static MovieDao getInstance() {
        if(instance == null)
            instance = new MovieDao();
        return instance;
    }

    private MovieDao() {
        movieList = new MutableLiveData<List<Movie>>(generateMovieList(10));;
    }

    public void delete(Movie movie) {
        List<Movie> tmpMovies = movieList.getValue();
        tmpMovies.remove(movie);
        movieList.setValue(tmpMovies);
    }

    public void startAutoAdding() {
        timer.start();
    }

    public void stopAutoAdding() {
        timer.cancel();
    }

    @NonNull
    private List<Movie> generateMovieList(int n) {
        List<Movie> movieList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            movieList.add(new Movie("The movie number " + ++numOfMovie, "https://picsum.photos/id/" + numOfMovie + "/200/300"));
        return movieList;
    }

    @NonNull
    private Movie generateMovie() {
        return new Movie("The movie number " + ++numOfMovie, "https://picsum.photos/id/" + numOfMovie + "/200/300");
    }
}
