package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoFromFuture {

  public static void main(String[] args) {

    Mono.fromFuture(getName()).subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

    // As it is asynchronous process
    // it is too fast and we have to
    // add timeout to display execution result
    // before process termination
    Util.sleepSeconds(1);

    // Result =>   Received: Ayesha Windler DDS
                 //Completed


  }

  public static CompletableFuture<String> getName(){
    // Asynchronous execution with CompletableFuture class
    return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
  }

}
