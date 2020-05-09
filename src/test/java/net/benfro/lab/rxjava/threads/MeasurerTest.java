package net.benfro.lab.rxjava.threads;

import org.junit.jupiter.api.Test;

/**
 * https://stackoverflow.com/questions/60343190/how-can-i-replace-inter-thread-communication-using-volatile-variables-with-rxjav
 */
class MeasurerTest {

   @Test
   void testIt() throws InterruptedException {
      Controller controller = new Controller();
      controller.setStat(Stat.BAR);

      @SuppressWarnings("unused")
      Measurer measurer = new Measurer(controller);

      Thread.sleep(5000);

      controller.setStat(Stat.FOO);

      Thread.sleep(5000);

      controller.setStat(Stat.BAR);

      Thread.sleep(5000);
   }
}
