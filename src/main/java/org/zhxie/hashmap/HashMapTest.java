package org.zhxie.hashmap;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  public static void main(String[] args) {
    Observable.just(1).doOnNext(e -> System.out.println("1 " + Thread.currentThread()))
        .doOnSubscribe(e -> System.out.println("2 " + Thread.currentThread()))
        .subscribeOn(Schedulers.computation())
        .doOnNext(e -> System.out.println("3 " + Thread.currentThread()))
        .doOnSubscribe(e -> System.out.println("4 " + Thread.currentThread()))
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(e -> System.out.println("5 " + Thread.currentThread()))
        .doOnNext(e -> System.out.println("6 " + Thread.currentThread()))
        .blockingSubscribe();
  }
}
