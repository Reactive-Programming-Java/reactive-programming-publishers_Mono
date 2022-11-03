package com.rp;

import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoJust {
  public static void main(String[] args) {

    // Mono is a publisher which can only emit 0 or 1 item
    Mono<Integer> monoJust = Mono.just(1);

    // Nothing append until we subscribe
    // Result: MonoJust
    System.out.println(monoJust);

    // Now we subscribe to the publisher
    monoJust.subscribe(i -> System.out.println("Received: "+i));

  }
}
