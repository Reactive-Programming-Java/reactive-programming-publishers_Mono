package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoFromCallable {
  public static void main(String[] args) {

    // Nothing should happen because we don't subscribe
    // Use just only we have data already there
   // Mono<String> mono = Mono.just(getName());

    // Instead we can use Mono from Callable
    // Callable has no input and return an object
    Callable<String> stringCallable = () -> getName();
    Mono<String> mono = Mono.fromCallable(stringCallable);
    mono.subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );


  }

  private static String getName(){
    System.out.println("Generating name...");
    return Util.faker().name().fullName();
  }
}
