package com.example.rxjava.chapter01;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
                .doOnNext(data -> System.out.println(getThreadName() + " : #doOnNext() : " + data)) // 이벤트가 발행될때 호출되는 함수
                .subscribeOn(Schedulers.io()) // 데이터의 발행, 흐름을 결정짓는 스레드를 지정
                .observeOn(Schedulers.computation()) // 구독해서 발행된 데이터를 가공하고 처리하는 스레드를 지정
                .filter(number -> number > 300) // 필터링
                .subscribe(number -> System.out.println(getThreadName() + " : result : " + number)); // 발행된 이벤트를 받아서 처리하는 함수

        Thread.sleep(500);
    }

    public static String getThreadName() { return Thread.currentThread().getName(); }
}
