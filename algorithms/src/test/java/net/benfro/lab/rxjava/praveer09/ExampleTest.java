package net.benfro.lab.rxjava.praveer09;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExampleTest {

   Example ex;

   @BeforeEach
   void setUp() {
      ex = new Example();
   }

   @Test
   void testGetsExecutedOnMainThread() {
      Observable.fromCallable(ex.thatReturnsNumberOne())     // the Observable
              .map(ex.numberToString())                      // the Operator
              .subscribe(ex.printResult());
   }

   @Test
   void testSubscribeOnGetsExecutedOnSchedulerThread() {
      Observable.fromCallable(ex.thatReturnsNumberOne())
              .subscribeOn(Schedulers.newThread())
              .map(ex.numberToString())
              .subscribe(ex.printResult());
   }

   @Test
   void testComputationOnMainAndSubscriptionOnOnSchedulerThread() {
      Observable.fromCallable(ex.thatReturnsNumberOne())
              .map(ex.numberToString())
              .observeOn(Schedulers.newThread())
              .subscribe(ex.printResult());
   }

   @Test
   void testComputationAndSubscriptionOnOnSchedulerThread() {
      Observable.fromCallable(ex.thatReturnsNumberOne())
              .observeOn(Schedulers.newThread())
              .map(ex.numberToString())
              .subscribe(ex.printResult());
   }

   @Test
   void testComputationAndSubscriptionOnOnDifferentSchedulerThread() {
      Observable.fromCallable(ex.thatReturnsNumberOne())
              .observeOn(Schedulers.newThread())
              .map(ex.numberToString())
              .observeOn(Schedulers.newThread())
              .subscribe(ex.printResult());
   }
}
