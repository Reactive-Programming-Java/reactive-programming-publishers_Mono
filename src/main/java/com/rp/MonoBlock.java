package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class MonoBlock {
  public static void main(String[] args) {
    //Here we are executing the pipeline
    // subscribeOn method is to add async feature
    // Then we are blocking the thread
    // and getting the name to display it
    String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
    System.out.println(name);
    // Result after blocking main thread:
    //Entered getName Method
    //Generating name...
    //ASIA HAUCK
    //Entered getName Method

    getName();


    Util.sleepSeconds(4);

  }


  private static Mono<String> getName(){
    System.out.println("Entered getName Method");

    // Here were are building the pipeline
    //-----------PIPELINE--------------------
    return Mono.fromSupplier(() -> {
      System.out.println("Generating name...");
      // Timeout of 3 secs before returning the name
      Util.sleepSeconds(3);
     return Util.faker().name().fullName();
    }).map(String::toUpperCase);
    //-----------PIPELINE--------------------
  }

}
