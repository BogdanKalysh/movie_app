package com.example.imagelist;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AutoItemAdder {
    MovieDao dao = MovieDao.getInstance();

    private final CountDownTimer timer = new CountDownTimer(5000, 1) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            dao.add(dao.generateMovie());
            start();
        }
    };

    public void startAutoAdding() {
        timer.start();
    }

    public void stopAutoAdding() {
        timer.cancel();
    }
}
