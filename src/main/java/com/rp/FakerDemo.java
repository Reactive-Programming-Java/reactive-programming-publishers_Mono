package com.rp;

import com.github.javafaker.Faker;
import com.rp.util.Util;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 03/11/2022
 */
public class FakerDemo {
  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      System.out.println(Util.faker().name().fullName());
    }

  }
}
