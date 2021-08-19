package com.example.imagelist;

public class AutoImageAdder {
    MovieDao dao = MovieDao.getInstance();

    public void startAutoAdding() {
        dao.startAutoAdding();
    }

    public void stopAutoAdding() {
        dao.stopAutoAdding();
    }
}
