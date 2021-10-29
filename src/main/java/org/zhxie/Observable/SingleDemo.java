package org.zhxie.Observable;

import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class SingleDemo {
  public static void main(String[] args) {
    final Single<String> stringSingle = Single.fromCallable(() -> {
      Thread.sleep(2000);
      ;
      return "test";
    });
    final Maybe<String> stringMaybe = stringSingle.subscribeOn(Schedulers.computation())
        .toMaybe()
        .cache()
        .observeOn(Schedulers.computation());
    final String stringMaybe2 = stringMaybe.blockingGet();
    System.out.println(stringMaybe2);
  }
}
