package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ObservableTakeUntilExample {
    public static void main(String[] args) {
//        Observable.fromIterable(Arrays.asList("a", "b", "c"))
//                .takeUntil((Predicate<? super String>) data -> data.equals("b"))
//                .subscribe(System.out::println);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .takeUntil(Observable.timer(5500, TimeUnit.MILLISECONDS))
                .subscribe(data -> Logger.log(LogType.DO_ON_NEXT, data));

        TimeUtil.sleep(5500);
    }
}
