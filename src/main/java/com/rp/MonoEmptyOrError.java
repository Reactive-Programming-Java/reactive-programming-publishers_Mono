package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoEmptyOrError {
  public static void main(String[] args) {
    // This the subscriber
    userRepository(1).subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

  }

  // This is the publisher
  private static Mono<String> userRepository(int userId){
     return (userId == 1) ? Mono.just(Util.faker().name().fullName()) : (userId == 2) ? Mono.empty() : Mono.error(new RuntimeException("Not allowed in the range"));
  }

}
