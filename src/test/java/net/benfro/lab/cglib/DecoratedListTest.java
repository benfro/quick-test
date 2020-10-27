package net.benfro.lab.cglib;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecoratedListTest {

   DecoratedList<String> instance;

   @BeforeEach
   void setUp() {
      instance = new DecoratedList<>(Lists.newArrayList("A", "B", "C"));
   }

   @Test
   void add() {
      assertTrue(instance.add("D"));
      assertEquals(4, instance.size());
      assertEquals(4, instance.getBackingMap().size());
   }

   @Test
   void testAdd() {
      instance.add(1, "D");
      assertEquals(4, instance.size());
      assertEquals(4, instance.getBackingMap().size());
      assertEquals(1, instance.indexOf("D"));
      assertEquals(2, instance.indexOf("B"));
      assertEquals(2, instance.getBackingMap().get("B"));
   }
}
