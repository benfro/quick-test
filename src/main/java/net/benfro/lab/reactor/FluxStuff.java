package net.benfro.lab.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxStuff {

   private Flux<String> s;

   static Flux<String> empty() {
      return Flux.empty();
   }

   static Flux<String> fromList(List<String> in) {
      return Flux.fromIterable(in);
   }

   void mono(long in) {
      Mono.just(in)
              .map(integer -> "foo" + integer)
              .subscribe(p -> System.out.println(p));
   }

}
