package net.benfro.lab.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

public class SimpleSubscriber<T> extends BaseSubscriber<T> {
   @Override
   public Context currentContext() {
      return null;
   }

   @Override
   protected Subscription upstream() {
      return super.upstream();
   }

   @Override
   public boolean isDisposed() {
      return super.isDisposed();
   }

   @Override
   public void dispose() {
      super.dispose();
   }

   @Override
   protected void hookOnSubscribe(Subscription subscription) {
      super.hookOnSubscribe(subscription);
   }

   @Override
   protected void hookOnNext(T value) {
      super.hookOnNext(value);
   }

   @Override
   protected void hookOnComplete() {
      super.hookOnComplete();
   }

   @Override
   protected void hookOnError(Throwable throwable) {
      super.hookOnError(throwable);
   }

   @Override
   protected void hookOnCancel() {
      super.hookOnCancel();
   }

   @Override
   protected void hookFinally(SignalType type) {
      super.hookFinally(type);
   }

   @Override
   public String toString() {
      return super.toString();
   }
}
