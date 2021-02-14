package org.zhxie.Observable.merge;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.TimeUnit;

public class Merge {


    public static void main(String[] args) {


        Observable<String> fast = Observable.interval(10, TimeUnit.MILLISECONDS).map(x -> "F".concat(String.valueOf(x)));

        Observable<String> slow = Observable.interval(17, TimeUnit.MILLISECONDS).map(x -> "S".concat(String.valueOf(x)));

        withLastFrom(slow, fast);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void combineLatest(ObservableSource<?> fast, ObservableSource<?> slow) {
        Observable.combineLatest(fast, slow, (s, f) -> f + ":" + s).forEach(System.out::println);
    }


    public static void withLastFrom(Observable<String> slow, Observable<String> fast) {
        slow.withLatestFrom(fast,(s, f) -> f + ":" + s).forEach(System.out::println);
    }
}
