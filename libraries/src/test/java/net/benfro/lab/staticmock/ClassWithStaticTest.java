package net.benfro.lab.staticmock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

@Disabled
class ClassWithStaticTest {

   @Test
   void testMockNoParameter() {
      assertNotEquals(0L, ClassWithStatic.noParameters());

      try (MockedStatic<ClassWithStatic> m = mockStatic(ClassWithStatic.class)) {
         m.when(ClassWithStatic::noParameters).thenReturn(0L);

         assertEquals(0L, ClassWithStatic.noParameters());

         m.verify(times(1), ClassWithStatic::noParameters);
      }
   }
}
