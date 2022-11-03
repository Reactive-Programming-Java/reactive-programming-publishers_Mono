package com.rp.util;

import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Consumer;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class Util {
  public static Consumer<Object> onNext(){
    return o -> System.out.println("Received: "+o);
  }

  public static Consumer<Throwable> onError(){
    return o -> System.out.println("ERROR: "+o.getMessage());
  }

  public static Runnable onComplete(){
    return () -> System.out.println("Completed");
  }
}
