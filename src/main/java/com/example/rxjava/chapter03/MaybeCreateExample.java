package com.example.rxjava.chapter03;

import com.example.rxjava.utils.DateUtil;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Maybe;

public class MaybeCreateExample {
    public static void main(String[] args) {
        // onSuccess 호출
        Maybe.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        // onComplete 호출
        Maybe.empty()
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
