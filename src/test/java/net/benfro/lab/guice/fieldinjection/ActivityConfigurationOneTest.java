package net.benfro.lab.guice.fieldinjection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActivityConfigurationOneTest {

   ActivityOne instance;

   @BeforeEach
   void setUp() {
      Injector injector = Guice.createInjector(new ModuleOne());
      instance = injector.getInstance(ActivityOne.class);
   }

   @Test
   void testInstance() {
      instance.perform();
   }
}
