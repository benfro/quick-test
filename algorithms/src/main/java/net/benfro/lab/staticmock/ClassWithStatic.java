package net.benfro.lab.staticmock;

public class ClassWithStatic {

   public static String doItStatically(String hej) {
      return "Hello " + hej;
   }

   public static Long noParameters() {
      return System.currentTimeMillis();
   }
}
