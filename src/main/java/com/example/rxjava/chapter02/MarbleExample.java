package com.example.rxjava.chapter02;

import io.reactivex.rxjava3.core.Observable;

public class MarbleExample {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(2, 25, 39, 15, 6);
        observable.subscribe(System.out::println);
    }
}
