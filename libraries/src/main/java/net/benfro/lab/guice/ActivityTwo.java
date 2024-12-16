package net.benfro.lab.guice;

import com.google.inject.Inject;
import net.benfro.lab.guice.model.Activity;
import net.benfro.lab.guice.model.ActivityConfiguration;

public class ActivityTwo implements Activity {

   private ActivityConfiguration config;

   @Inject
   public ActivityTwo(ActivityConfiguration config) {
      this.config = config;
   }

   @Override
   public void perform() {

   }

   @Override
   public ActivityConfiguration getConfiguration() {
      return config;
   }
}
