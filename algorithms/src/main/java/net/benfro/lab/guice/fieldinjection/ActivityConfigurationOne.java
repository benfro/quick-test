package net.benfro.lab.guice.fieldinjection;

import com.google.inject.Inject;
import net.benfro.lab.guice.model.ActivityConfiguration;
import net.benfro.lab.guice.model.Validator;

public class ActivityConfigurationOne implements ActivityConfiguration {

   @Inject
   private Validator validator;

   @Override
   public boolean isValid() {
      return validator.isValid();
   }


}
