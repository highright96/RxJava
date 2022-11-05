package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {
    public static void main(String[] args) throws InterruptedException {
        Observable.timer(2000, TimeUnit.MICROSECONDS)
                .map(count -> "Do work!")
                .subscribe(data -> Logger.log(LogType.DO_ON_SUBSCRIBE, data));

        TimeUtil.sleep(3000L);
    }
}
