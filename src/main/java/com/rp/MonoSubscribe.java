package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoSubscribe {
  public static void main(String[] args) {
    // Publisher
    Mono<String> mono = Mono.just("John");

    // Using onNext (First parameter) to push data to subscriber
    // Result: John
    //         Completed
    mono.subscribe(
      Util.onNext(), // OnNext
      Util.onError(), // OnError
      Util.onComplete() // onComplete
    );
  }
}
