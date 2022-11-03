package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class SupplierRefactoringWithPipelineAndExecution {
  public static void main(String[] args) {
    //Here we are executing the pipeline
    // via subscribe method
    getName().subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

    // That thread is processed after the first above
    getName();

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
