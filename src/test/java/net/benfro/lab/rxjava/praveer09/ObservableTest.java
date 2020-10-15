package net.benfro.lab.rxjava.praveer09;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

public class ObservableTest {
   @Test
   void testObservableJust() {
      Observable<String> just = Observable.just("apa", "banan", "apelsin");

      just.subscribe(s -> System.out.println(s));
   }
}
