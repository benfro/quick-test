package net.benfro.lab.reactor;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class FluxStuffTest {

   @Test
   void testMono() {
      new FluxStuff().mono(1000);
   }

   @Test
   void testSome() {
      Flux.range(1, 10)
              .doOnRequest(r -> System.out.println("request of " + r))
              .subscribe(new BaseSubscriber<Integer>() {

                 @Override
                 public void hookOnSubscribe(Subscription subscription) {
                    request(1);
                 }

                 @Override
                 public void hookOnNext(Integer integer) {
                    System.out.println("Cancelling after having received " + integer);
                    cancel();
                 }
              });
   }

   @Test
   void testGenerate() {
//      Flux<String> flux = Flux.generate(
//              () -> 0,
//              (state, sink) -> {
//                 sink.next("3 x " + state + " = " + 3 * state);
//                 //System.out.println("sink.currentContext()");
//                 if (state == 10) sink.complete();
//                 return state + 1;
//              });
//
//      flux.subscribe(new BaseSubscriber<String>() {
//
//         @Override
//         public void hookOnSubscribe(Subscription subscription) {
//            request(8);
//         }
//
//         @Override
//         public void hookOnNext(String integer) {
//            System.out.println("Cancelling after having received " + integer);
//            cancel();
//         }
//      });

      List<String> giveMe = Lists.newArrayList();
      Flux<String> flux2 = Flux.generate(
              AtomicLong::new,
              (state, sink) -> {
                 long i = state.getAndIncrement();
                 sink.next("3 x " + i + " = " + 3 * i);
                 if (i == 10) sink.complete();
                 return state;
              }, (state) -> giveMe.add(state + ""));

      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      giveMe.forEach(s -> System.out.println(s));

   }
}
