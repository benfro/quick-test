package net.benfro.lab.lists;

import java.util.ArrayList;
import java.util.Arrays;

public class Lists {

   private Lists() {}

   public static <T> ArrayList<T> newArrayList() {
      return new ArrayList<>();
   }

   public static <T> ArrayList<T> newArrayList(int initialCapacity) {
      return new ArrayList<>(initialCapacity);
   }

   public static <T> ArrayList<T> newArrayList(T first, T... others) {
      ArrayList<T> list = new ArrayList<>();
      list.add(first);
      list.addAll(Arrays.asList(others));
      return list;
   }

}
