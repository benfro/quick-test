package net.benfro.lab.chonmap;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

class MapBuilderTest {

   @Test
   void testMD5Contect() {
      MapBuilder instance = new MapBuilder();
      System.out.println(instance.md5Content("/Users/benfro", "Downloads", "hhh.jpg"));
   }

   @Test
   void testWalk() {
      MapBuilder instance = new MapBuilder();
      try {
         instance.walk(Paths.get("/Users/benfro", "Downloads"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
