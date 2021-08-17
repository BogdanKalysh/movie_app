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

import java.util.List;

public class MoviesAdapter extends ListAdapter<Movie, MoviesAdapter.MovieHolder> {
    private MovieRepository repository;

    protected MoviesAdapter(MovieRepository repository) {
        super(DIFF_CALLBACK);
        this.repository = repository;
    }

    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getUrl().equals(newItem.getUrl());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = getItem(position);
        holder.bind(movie);
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
