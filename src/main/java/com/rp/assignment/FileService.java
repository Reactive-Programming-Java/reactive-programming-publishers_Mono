package com.rp.assignment;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * @PROJECT Mono_Project
 * @Author Elimane on 04/11/2022
 */
public class FileService {
  public static void main(String[] args) {


    Mono.fromRunnable(createFile("myFile")).subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

    Mono.fromRunnable(readFile("myFile")).subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

//    Mono.fromRunnable(deleteFile("myFile")).subscribe(
//      Util.onNext(),
//      Util.onError(),
//      Util.onComplete()
//    );



  }

  private static Runnable createFile(String filename){
    System.out.println("Creating file "+filename+"...");
    return () -> {
      try {
        Util.sleepSeconds(1);
        Path file = Util.FILEPATH.resolve(filename+".txt").normalize();
        Files.createFile(file);
        Files.writeString(file, "This is file "+filename);
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
  }

  private static Runnable readFile(String  fileName){
    System.out.println("Reading file "+fileName+"...");
    return () -> {
      try {
        Path file = Util.FILEPATH.resolve(fileName+".txt").normalize();
        Files.lines(file, Charset.forName("UTF-8")).forEach(line -> {
          System.out.println(line);
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
  }

  private static Runnable deleteFile(String filename) {
    System.out.println("Deleting file...");
    return () -> {
      try {
        Util.sleepSeconds(1);
        Path file = Util.FILEPATH.resolve(filename+".txt").normalize();
        Files.delete(file);
        System.out.println("File deleted");
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
  }

}
