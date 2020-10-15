package net.benfro.lab.algo;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

   static HappyNumber happy = new HappyNumber();


   @ValueSource(ints = {1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100, 103, 109, 129,
           130, 133, 139, 167, 176, 188, 190, 192, 193, 203, 208, 219, 226, 230, 236, 239, 262, 263, 280, 291, 293, 301,
           302, 310, 313, 319, 320, 326, 329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391, 392, 397, 404,
           409, 440, 446, 464, 469, 478, 487, 490, 496, 536, 556, 563, 565, 566, 608, 617, 622, 623, 632, 635, 637, 638,
           644, 649, 653, 655, 656, 665, 671, 673, 680, 683, 694, 700, 709, 716, 736, 739, 748, 761, 763, 784, 790, 793,
           802, 806, 818, 820, 833, 836, 847, 860, 863, 874, 881, 888, 899, 901, 904, 907, 910, 912, 913, 921, 923, 931,
           932, 937, 940, 946, 964, 970, 973, 989, 998, 1000})
   public void testShouldBeTrue(int in) {
      //boolean happyNumber = happy.isHappyNumber(in);
      assertTrue(happy.isHappyNumber2(in));
      //assertTrue(happyNumber) ;
   }

   static Stream<Integer> intProvider() {
      List<Integer> out = Lists.newArrayList();
      for (int i = 0; i < 100000000; i++) {
         out.add(ThreadLocalRandom.current().nextInt(1, 100000000 + 1));
      }
      return out.stream();
   }

   @ParameterizedTest
   @ValueSource(ints = {5, 33, 882})
   public void testShouldBeFalse(int in) {
      assertFalse(new HappyNumber().isHappyNumber2(in));
   }

   @Test
   void testSplit() {
      assertEquals(Lists.newArrayList(1, 0, 0), new HappyNumber().splitNum(100));
   }

   @Test
   void testAllUnique() {
      assertTrue(new HappyNumber().allUnique("ABC"));
   }

   @Test
   void testSum() {
      assertEquals(82, new HappyNumber().powSum(19));
   }
}
