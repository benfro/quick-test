package net.benfro.lab.lists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListsTest {

   @Test
   void testNewArrayList() {
      List<String> l = Lists.newArrayList();
      l.add("A");
   }

   @Test
   void testWithContent() {
      List<String> l = Lists.newArrayList("A");
      assertEquals(1, l.size());
   }

   @Test
   void testWithContent2() {
      List<String> l = Lists.newArrayList("A","B", "C");
      assertEquals(3, l.size());
   }
}
