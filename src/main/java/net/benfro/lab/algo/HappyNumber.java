package net.benfro.lab.algo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HappyNumber {

   ///private final Set<Integer> used = Sets.newHashSet();

   public boolean isHappyNumber(int candidate) {
      final Set<Integer> used = Sets.newHashSet();
      Integer reduce = splitNum(candidate).stream().mapToInt(v -> v * v).boxed().reduce(0, Integer::sum);
      if (reduce == 1) {
         return true;
      }
      if (used.contains(reduce)) {
         return false;
      }
      used.add(reduce);
      return isHappyNumber(reduce);
   }

   public boolean isHappyNumber2(int candidate) {
      boolean flag = false;
      if (candidate < 1) {
         return false;
      }
      while (true) {
         candidate = powSum(candidate);
         if (candidate == 1 || candidate == 7) {
            flag = true;
            break;
         } else if (candidate % 10 == candidate) {
            flag = false;
            break;
         }
      }
      return flag;
   }

   int powSum(int candidate) {
      int sum = 0;
      int temp = candidate;
      while (temp >= 10) {
         int rest = temp % 10;
         sum += rest * rest;
         temp /= 10;
      }
      sum += temp * temp;
      return sum;
   }

   List<Integer> splitNum(int in) {
      List<Integer> out = Lists.newArrayList();
      int temp = in;
      while (temp >= 10) {
         out.add(temp % 10);
         temp /= 10;
      }
      out.add(temp);
      Collections.reverse(out);
      return out;
   }

   boolean allUnique(String str) {
      return str.chars().boxed().collect(Collectors.toSet()).size() == str.length();
   }

}
