package net.benfro.lab.guice.fieldinjection;

import com.google.inject.Inject;
import net.benfro.lab.guice.model.Activity;
import net.benfro.lab.guice.model.ActivityConfiguration;

public class ActivityOne implements Activity {

   @Inject
   private ActivityConfiguration config;

   @Override
   public void perform() {

   }

   @Override
   public ActivityConfiguration getConfiguration() {
      return config;
   }
}
