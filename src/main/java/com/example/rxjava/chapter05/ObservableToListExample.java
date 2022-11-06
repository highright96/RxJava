package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableToListExample {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .toList()
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
