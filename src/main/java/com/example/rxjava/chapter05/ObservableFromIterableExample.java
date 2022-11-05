package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

public class ObservableFromIterableExample {
    public static void main(String[] args) {
        Observable.fromIterable(Arrays.asList("a", "b", "c", "d"))
                .subscribe(data -> {
                    TimeUtil.sleep(1000);
                    Logger.log(LogType.ON_NEXT, data);
                });
    }
}