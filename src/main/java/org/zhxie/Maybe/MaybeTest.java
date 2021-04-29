package org.zhxie.Maybe;

import io.reactivex.Maybe;

public class MaybeTest {

  public static void main(String[] args) {
    Maybe.error(new Exception("exception test")).onErrorComplete().subscribe(e -> {
      System.out.println(e); // nothing output
    });
  }
}
