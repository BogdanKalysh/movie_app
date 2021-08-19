package com.example.imagelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imagelist.databinding.MovieItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter <MoviesAdapter.MovieHolder> {
    private List<Movie> movieList;
    private MovieRepository repository;

    protected MoviesAdapter(MovieRepository repository) {
        movieList = new ArrayList<Movie>();
        this.repository = repository;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setList(List<Movie> movieList) {
        MovieDiffUtilCallback differ = new MovieDiffUtilCallback(this.movieList, movieList);
        DiffUtil.DiffResult movieDiffResult = DiffUtil.calculateDiff(differ);

        System.out.println(this.movieList.size());
        System.out.println(movieList.size());

        this.movieList = movieList;
        movieDiffResult.dispatchUpdatesTo(this);
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        private MovieItemBinding movieBinding;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            movieBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(Movie movie) {
            movieBinding.setMovie(movie);

            movieBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    repository.delete(movie);
                    return true;
                }
            });
        }
    }

    @BindingAdapter("ImageUrl")
    public static void loadImage(ImageView view, String url){
        Glide.with(view.getContext()).load(url).into(view);
    }
}
