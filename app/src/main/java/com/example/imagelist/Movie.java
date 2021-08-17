package com.example.imagelist;

public class Movie {
    public String name, url;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Movie(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if(!(obj instanceof Movie)) {
            return false;
        }

        Movie movie = (Movie)obj;
        return this.name.equals(movie.name) && this.url.equals(movie.name);
    }
}
