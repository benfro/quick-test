package net.benfro.lab.guice;


import net.benfro.lab.guice.model.Validator;

public class ValidatorTwo implements Validator {

   private boolean returnValue;

   public ValidatorTwo(boolean returnValue) {
      this.returnValue = returnValue;
   }

   @Override
   public boolean isValid() {
      return returnValue;
   }
}
