package com.example.rxjava.chapter05;

import io.reactivex.rxjava3.core.Observable;

public class ObservableFlatMapExample {
    public static void main(String[] args) {
        Observable.just("Hello")
                .flatMap(hello -> Observable.just("자바", "파이썬", "코틀린").map(lang -> hello + ", " + lang))
                .subscribe(System.out::println);

        Observable.just("Hello")
                .flatMap(
                    hello -> Observable.just("자바", "파이썬", "코틀린"),
                    (source, transformed) -> source + ", " + transformed
                )
                .subscribe(System.out::println);
    }
}
