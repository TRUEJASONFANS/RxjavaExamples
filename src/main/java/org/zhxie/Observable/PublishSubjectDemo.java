package org.zhxie.Observable;


import io.reactivex.subjects.PublishSubject;

public class PublishSubjectDemo {

  public static void main(String[] args) {
    PublishSubject<String> publish = PublishSubject.create();
    publish.subscribe((s)-> {
      System.out.println(s);
    });
    publish.onNext("1");
    publish.onNext("2");
    publish.subscribe((s)-> {
      System.out.println(s);
    });
    publish.onNext("3");
    publish.onComplete();
  }
}
