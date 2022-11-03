package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoSubscribeOnError {
  public static void main(String[] args) {
    // Publisher
    Mono<Integer> mono = Mono.just("John")
                             .map(String::length)
                             .map(l -> l / 0); // There an error (Arithmetic Exception)

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
