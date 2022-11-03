package com.rp;

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
      item -> System.out.println(item), // OnNext
      err -> System.out.println("ERROR: "+err.getMessage()), // OnError
      () -> System.out.println("Completed") // onComplete
    );
  }
}
