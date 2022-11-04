package com.rp;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 04/11/2022
 */
public class MonoFromRunnable {
  public static void main(String[] args) {

    Mono.fromRunnable(timeConsumingProcess()).subscribe(
      Util.onNext(),
      Util.onError(),
      () -> {
        System.out.println("Process is done using emails...");
      }
    );

  }

  private static Runnable timeConsumingProcess(){
    return () -> {
      Util.sleepSeconds(3);
      System.out.println("Operation completed");
    };
  }
}
