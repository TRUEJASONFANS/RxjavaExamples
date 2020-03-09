package org.zhxie;

import io.reactivex.Observable;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class ObservableIntervalTest {

    public static void main(String[] args) {
        final Observable<Long> take = Observable.interval(0, 50, TimeUnit.MILLISECONDS)
                .skip(2)
                .take(60);
        take.subscribe(p-> {
            System.out.println(p);
        });
        while(true) {

        }
    }
}
