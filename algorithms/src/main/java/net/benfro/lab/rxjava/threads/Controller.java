package net.benfro.lab.rxjava.threads;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Controller {
   private Subject<Stat> statSubject;

   public Controller() {
      statSubject = BehaviorSubject.<Stat>create().toSerialized();
   }

   public Observable<Stat> getStatChange() {
      return statSubject.distinctUntilChanged();
   }

   public void setStat(Stat stat) {
      statSubject.onNext(stat);
   }
}
