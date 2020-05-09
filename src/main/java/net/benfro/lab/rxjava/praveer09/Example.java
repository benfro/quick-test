package net.benfro.lab.rxjava.praveer09;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

import java.util.concurrent.Callable;

/**
 * https://praveer09.github.io/technology/2016/02/29/rxjava-part-3-multithreading/
 */
public class Example {

   Callable<Integer> thatReturnsNumberOne() {
      return () -> {
         System.out.println("Observable thread: " + Thread.currentThread().getName());
         return 1;
      };
   }

   Function<Integer, String> numberToString() {
      return number -> {
         System.out.println("Operator thread: " + Thread.currentThread().getName());
         return String.valueOf(number);
      };
   }

   Consumer<String> printResult() {
      return result -> {
         System.out.println("Subscriber thread: " + Thread.currentThread().getName());
         System.out.println("Result: " + result);
      };
   }
}
