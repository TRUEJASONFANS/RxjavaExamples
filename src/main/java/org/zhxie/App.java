package org.zhxie;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import org.reactivestreams.Subscription;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PublishSubject<String> stringPublishSubject = PublishSubject.create();

        stringPublishSubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
              System.out.println("on subscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("on error");
            }

            @Override
            public void onComplete() {
                System.out.println("on complete");
            }
        });
      stringPublishSubject.onNext("hello world");
      stringPublishSubject.onComplete();
    }
}
