package org.zhxie.Observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class ObserableIterable {

  public static void testObservableCreate() {
    final Observable<Object> objectObservable = Observable.create(emitter -> {
      emitter.onNext(1);
    });
    objectObservable.subscribe(e -> {
      System.out.println(e);
    });
  }

  @SuppressWarnings("unchecked")
  public static <T extends Throwable, R> R throwAsUncheck(Throwable t) throws T {
    T t2 = (T) t;
    System.out.println(t.getClass());
    throw (T) t;
  }

  public static void test() throws Exception {
    throw new Exception("sss");
  }


  public static void main(String[] args) {
    //testObservableCreate();

    try {
      test();
    } catch (Exception e) {
      throwAsUncheck(e);
    }


//        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//                e.onNext(4);
//            }
//        }).subscribe(new Observer<Integer>() { // 第三步：订阅
//
//            // 第二步：初始化Observer
//            private int i;
//            private Disposable mDisposable;
//
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                mDisposable = d;
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                System.out.println(integer);
//                i++;
//                if (i == 2) {
//                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                }
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        });
//        while(true) {
//
//        }
  }
}
