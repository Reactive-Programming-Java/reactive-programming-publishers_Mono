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


    create("myFile").subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

    read("myFile").subscribe(
      Util.onNext(),
      Util.onError(),
      Util.onComplete()
    );

//    delete("myFile").subscribe(
//      Util.onNext(),
//      Util.onError(),
//      Util.onComplete()
//    );



  }

  public static Mono<Void> create(String filename){
    return Mono.fromRunnable(() -> createFile(filename));
  }

  public static Mono<String> read(String filename){
    return Mono.fromSupplier(() -> readFile(filename));
  }

  public static Mono<Void> delete(String filename){
    return Mono.fromRunnable(() -> deleteFile(filename));
  }


  private static void createFile(String filename){
    System.out.println("Creating file "+filename+"...");
      try {
        Util.sleepSeconds(1);
        Path file = Util.FILEPATH.resolve(filename+".txt").normalize();
        Files.createFile(file);
        Files.writeString(file, "This is file "+filename);
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
      }
  }

  private static String readFile(String  fileName){
    System.out.println("Reading file "+fileName+"...");
      try {
        return Files.readString(Util.FILEPATH.resolve(fileName+".txt").normalize());
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
      }
  }

  private static void deleteFile(String filename) {
    System.out.println("Deleting file...");
      try {
        Util.sleepSeconds(1);
        Files.delete(Util.FILEPATH.resolve(filename+".txt").normalize());
        System.out.println("File deleted");
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
      }
  }

}
