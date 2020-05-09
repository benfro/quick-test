package net.benfro.lab.guice;

import com.google.inject.Inject;
import net.benfro.lab.guice.model.ActivityConfiguration;
import net.benfro.lab.guice.model.Validator;

public class ActivityConfigurationTwo implements ActivityConfiguration {

   private Validator validator;

   @Inject
   public ActivityConfigurationTwo(Validator validator) {
      this.validator = validator;
   }

   @Override
   public boolean isValid() {
      return validator.isValid();
   }
}
