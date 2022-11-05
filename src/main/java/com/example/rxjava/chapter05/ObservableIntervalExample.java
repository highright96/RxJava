package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
