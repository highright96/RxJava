package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

public class ObservableDelayExample {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7)
                .delay(item -> {
                    TimeUtil.sleep(1000L);
                    return Observable.just(item); // 새로운 Observable의 통지 시점에, 원본 데이터를 통지한다.
                }).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
