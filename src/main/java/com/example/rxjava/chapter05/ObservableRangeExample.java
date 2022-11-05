package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableRangeExample {
    public static void main(String[] args) {
        Observable.range(0, 5)
                .subscribe(num -> Logger.log(LogType.ON_NEXT, num));
    }
}
