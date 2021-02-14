package org.zhxie.Observable;

import io.reactivex.Observable;

public class Callable {

    public static void main(String[] args) {

        Observable ob = Observable.fromCallable(()-> {System.out.println("sss"); return 1;});
        ob.subscribe(s-> {});
    }

}
