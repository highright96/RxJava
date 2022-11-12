package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorResumeNextExample {
    public static void main(String[] args) {
        Observable.just(5L)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num / i)
                        .onErrorResumeNext(throwable -> {
                            Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송: " + throwable.getMessage());
                            return Observable.interval(200L,TimeUnit.MILLISECONDS).take(5).skip(1).map(i -> num / i);
                        })
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
