package com.rp;

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
      item -> System.out.println(item), // OnNext
      err -> System.out.println(err), // OnError
      () -> System.out.println("Completed") // onComplete
    );
  }
}
