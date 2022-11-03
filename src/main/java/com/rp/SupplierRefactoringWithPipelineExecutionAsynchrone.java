package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class SupplierRefactoringWithPipelineExecutionAsynchrone {
  public static void main(String[] args) {
    //Here we are executing the pipeline
    // via subscribe method
    // subscribeOn method is to add async feature
    getName().subscribeOn(Schedulers.boundedElastic()).subscribe(
      Util.onNext()
    );
    // Result after blocking main thread:
    //Entered getName Method
    //Entered getName Method
    //Generating name...

    getName();

    // we have to block main thread with 4 seconds timeout
    // in order to make main thread closing in late to see Generated name
    // from pipeline execution
    Util.sleepSeconds(4);
    // Result after blocking main thread:
    //Entered getName Method
    //Entered getName Method
    //Generating name...
    //Received: SABRINA KOEPP <= Name is appearing because of timeout

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
