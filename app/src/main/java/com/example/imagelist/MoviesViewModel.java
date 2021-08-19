package com.example.imagelist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    private MovieRepository repository;
    private AutoItemAdder autoAdder;
    private MutableLiveData<Boolean> autoAddingState;
    private LiveData<List<Movie>> movieList;

    public void setAutoAddingState(boolean state) {
        if(state != autoAddingState.getValue()) {
            autoAddingState.setValue(state);
            if (state)
                startAutoAdding();
            else
                stopAutoAdding();
        }
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public MovieRepository getRepository() {
        return repository;
    }

    public LiveData<Boolean> getAutoAddingState() {
        return autoAddingState;
    }

    public MoviesViewModel() {
        autoAddingState = new MutableLiveData<Boolean>(false);
        repository = new MovieRepository();
        autoAdder = new AutoItemAdder();
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
