package net.benfro.lab.guice.fieldinjection;


import net.benfro.lab.guice.model.Validator;

public class ValidatorOne implements Validator {

   @Override
   public boolean isValid() {
      return true;
   }
}
