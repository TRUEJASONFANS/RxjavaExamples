package org.zhxie.schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerTest {

  public static void main(String[] args) {
    Observable.just(1)
        .doOnSubscribe(e -> System.out.println("1" + Thread.currentThread()))
        .observeOn(Schedulers.computation())
        .doOnSubscribe(e -> System.out.println("2" + Thread.currentThread()))
        .subscribeOn(Schedulers.computation())
        .doOnSubscribe(e -> System.out.println("3" + Thread.currentThread()))
        .doOnSubscribe(e -> System.out.println("4" + Thread.currentThread()))
        .blockingSubscribe();
  }
}
