package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.time.LocalTime;

public class ObservableDeferExample {
    public static void main(String[] args) {
        Observable<LocalTime> observable = Observable.defer(() -> Observable.just(LocalTime.now()) );
        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독 1의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독 1의 구독 시간: " + time));

        TimeUtil.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독 2의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독 2의 구독 시간: " + time));
    }
}
