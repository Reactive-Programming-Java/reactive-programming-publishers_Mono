package com.rp.util;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Consumer;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class Util {

  private static final Faker FAKER = Faker.instance();

  public static Consumer<Object> onNext(){
    return o -> System.out.println("Received: "+o);
  }

  public static Consumer<Throwable> onError(){
    return o -> System.out.println("ERROR: "+o.getMessage());
  }

  public static Runnable onComplete(){
    return () -> System.out.println("Completed");
  }

  public static Faker faker(){
    return FAKER;
  }
}
