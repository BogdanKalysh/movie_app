package com.example.imagelist;

public class AutoItemAdder {
    MovieDao dao = MovieDao.getInstance();

    public void startAutoAdding() {
        dao.startAutoAdding();
    }

    public void stopAutoAdding() {
        dao.stopAutoAdding();
    }
}
