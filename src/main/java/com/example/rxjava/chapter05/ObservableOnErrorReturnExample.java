package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorReturnExample {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(num -> Observable
                        .interval(200, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num / i)
                        .onErrorReturn(exception -> {
                            Logger.log(LogType.PRINT, "계산 처리 에러 발생");
                            return -1L;
                        })
                )
                .subscribe(
                        data -> {
                            if (data < 0) Logger.log(LogType.PRINT, "계산 처리 에러 발생");
                            else Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.PRINT, "계산 처리 에러 발생"),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(1000L);
    }
}
