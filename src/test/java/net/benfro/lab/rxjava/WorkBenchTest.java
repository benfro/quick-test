package net.benfro.lab.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://github.com/ReactiveX/RxJava
 */
class WorkBenchTest {

   @Test
   void nonParallell() {
      @NonNull Single<List<Integer>> collect = Flowable.range(1, 10)
              .observeOn(Schedulers.computation())
              .map(v -> v * v)
              //.blockingSubscribe(System.out::println);
              .collect(Collectors.toList());
      collect.blockingGet().forEach(s -> System.out.println(s));
   }

   @Test
   void parallell() {
      Flowable.range(1, 10)
              .flatMap(v ->
                      Flowable.just(v)
                              .subscribeOn(Schedulers.computation())
                              .map(w -> w * w)
              )
              .blockingSubscribe(System.out::println);
   }

   @Test
   void parallel2() {
      Flowable.range(1, 10)
              .parallel()
              .runOn(Schedulers.computation())
              .map(v -> v * v)
              .sequential()
              .blockingSubscribe(System.out::println);
   }
}
