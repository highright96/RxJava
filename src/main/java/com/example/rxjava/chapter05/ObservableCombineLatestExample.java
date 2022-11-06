package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample {
    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(4);

        Observable<Long> observable2 = Observable.interval(200, TimeUnit.MILLISECONDS)
                .take(6);

        Observable.combineLatest(observable1, observable2, (data1, data2) -> "data1 : " + data1 + ", data2 : " + data2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4500);
    }
}
