package net.benfro.lab.guice.fieldinjection;

import com.google.inject.AbstractModule;
import net.benfro.lab.guice.model.ActivityConfiguration;
import net.benfro.lab.guice.model.Validator;

public class ModuleOne extends AbstractModule {

   @Override
   protected void configure() {
      bind(ActivityConfiguration.class).to(ActivityConfigurationOne.class);
      bind(Validator.class).to(ValidatorOne.class);
   }
}
