package org.zhxie.Completable;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;

public class CompletableDemo {

    public static void main(String[] args) {
        Completable
                .complete()
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        System.out.println("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                      e.printStackTrace();
                    }
                });

      Completable.fromRunnable(() -> {
        System.out.println("Completed instant");
      }).subscribe(
          () -> {
            System.out.println("Completed received");
          }
      );

//      Completable.fromRunnable();

    }
}
