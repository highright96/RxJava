package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample {
    public static void main(String[] args) {
//        Observable.just(5)
//                .flatMap(
//                        num -> Observable
//                                .interval(200L, TimeUnit.MILLISECONDS)
//                                .map(i -> {
//                                    long result;
//                                    try{
//                                        result = num / i;
//                                    }catch(ArithmeticException ex){
//                                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
//                                        throw ex;
//                                    }
//                                    return result;
//                                })
//                                .retry(5)
//                                .onErrorReturn(throwable -> -1L)
//                ).subscribe(
//                        data -> Logger.log(LogType.ON_NEXT, data),
//                        error -> Logger.log(LogType.ON_ERROR, error),
//                        () -> Logger.log(LogType.ON_COMPLETE)
//                );
//
//        TimeUtil.sleep(5000L);

//        Observable.just(5)
//                .flatMap(
//                        num -> Observable
//                                .interval(200L, TimeUnit.MILLISECONDS)
//                                .map(i -> {
//                                    long result;
//                                    try{
//                                        result = num / i;
//                                    }catch(ArithmeticException ex){
//                                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
//                                        throw ex;
//                                    }
//                                    return result;
//                                })
//                                .retry((retryCount, ex) -> {
//                                    Logger.log(LogType.PRINT, "# 재시도 횟수: " + retryCount);
//                                    TimeUtil.sleep(1000L);
//                                    return retryCount < 5;
//                                })
//                                .onErrorReturn(throwable -> -1L)
//
//                ).subscribe(
//                        data -> Logger.log(LogType.ON_NEXT, data),
//                        error -> Logger.log(LogType.ON_ERROR, error),
//                        () -> Logger.log(LogType.ON_COMPLETE)
//                );
//
//        TimeUtil.sleep(6000L);

        Observable.just(10, 12, 15, 16)
                .zipWith(Observable.just(1, 2, 0, 4), (a, b) -> {
                    int result;
                    try{
                        result = a / b;
                    }catch(ArithmeticException ex){
                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
                        throw ex;
                    }
                    return result;
                })
                .retry(2)
                .onErrorReturn(throwable -> -1)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(5000L);
    }
}
