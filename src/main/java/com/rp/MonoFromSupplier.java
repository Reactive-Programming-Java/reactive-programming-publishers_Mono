package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoFromSupplier {
  public static void main(String[] args) {

    // Nothing should happen because we don't subscribe
    // Use just only we have data already there
   // Mono<String> mono = Mono.just(getName());

    // Instead we can use Mono from supplier
    Mono<String> mono = Mono.fromSupplier(() -> getName());
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
