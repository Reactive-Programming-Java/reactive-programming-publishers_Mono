package com.rp;

import java.util.stream.Stream;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class LazyStream {
  public static void main(String[] args) {
    Stream<Integer> integerStream = Stream.of(1).map(i -> {
      try {
        // It takes 1 second before return data processed
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return i * 2;
    });
    // Result: java.util.stream.ReferencePipeline$3@4a574795
    //No significant result because Stream is lazy unless we add it a terminal operator
    System.out.println(integerStream);

    // Here we added terminal operator (foreach)
    // Result: 2
    integerStream.forEach(System.out::println);
  }
}
