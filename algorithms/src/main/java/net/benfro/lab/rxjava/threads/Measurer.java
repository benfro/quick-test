package net.benfro.lab.rxjava.threads;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Measurer {

   public Measurer(Controller controller) {
      Observable.timer(1, TimeUnit.SECONDS, Schedulers.newThread())
              .repeat()
              .withLatestFrom(
                      controller.getStatChange(),
                      (__, stat) -> stat) // ignore the Long emitted by timer
              .subscribe(this::measureStat);
   }

   private void measureStat(Stat stat) {
      switch (stat) {
         case FOO:
            measureFoo();
            break;

         case BAR:
            measureBar();
            break;

         default:
            break;
      }
   }

   private void measureBar() {
      System.out.println("Measuring Bar");
   }

   private void measureFoo() {
      System.out.println("Measuring Foo");
   }
}
