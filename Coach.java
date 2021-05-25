import ou.*;
/**
 * Instances of the Coach class orchestrate repetitions of sprinting
 * for two FitnessFrog objects, sporty1 and sporty1.
 * 
 * @author M250 Module Team 
 * @version 1.4
 */

public class Coach
{
   // instance variables
   private FitnessFrog sporty1;
   private FitnessFrog sporty2;

   /**
    * Constructor for objects of class Coach.
    */
   public Coach(FitnessFrog fitnessFrog1, FitnessFrog fitnessFrog2)
   {
      super();
      this.sporty1 = fitnessFrog1;
      this.sporty2 = fitnessFrog2;
   }

   /**
    * Getter for sporty1.
    */
   public FitnessFrog getSporty1()
   {
      return this.sporty1;
   }  

   /**
    * Getter for sporty2.
    */
   public FitnessFrog getSporty2()
   {
      return this.sporty2;
   }   
      
   /**
    * Returns the number of repetitions (between 1 and 5 inclusive)
    * specified by the user via a dialogue box. If the user does not enter any value
    * or number of repetitions is less than 1 or more that 5 then a dialog box appears with 
    * an appropriate message.
    */
   private int getNumberRepetitions()
   {
      String repetitionString;
      int repetitions = 0;
      boolean again = true;

      while (again)
      {
         repetitionString =
          OUDialog.request("Enter the number of repetitions for the training session");
         try
         {
            repetitions = Integer.parseInt(repetitionString);
            if ((repetitions < 1) || (repetitions > 5))
            {
               OUDialog.alert("Entered value is outside range (between 1 and 5 inclusive)");
            }
            else
            {
               again = false;
            }
         }
         catch (NumberFormatException anException)
         {
            OUDialog.alert("You did not enter any value");
            again = false;
         }
      }
      return repetitions;
   }    
   
   /**
    * Changes the colour of the Fitness Frog that has sprinted the furthest, if there is one, to
    * yellow and makes it croak once. Takes no arguments and returns no value.
    */
   private void announceFittestFrog()
   {
      int distanceSporty1 = this.getSporty1().getTotalDistanceSprinted();
      int distanceSporty2 = this.getSporty2().getTotalDistanceSprinted();
      if(distanceSporty1 > distanceSporty2)
      {
         this.getSporty1().setColour(OUColour.YELLOW);
         this.getSporty1().croak();
      }
      if(distanceSporty1 < distanceSporty2)
      {
         this.getSporty2().setColour(OUColour.YELLOW);
         this.getSporty2().croak();
      }  
   }
   
   /**
    * First checks if both Fitness Frogs are currently positioned on the running
    * track (black stones numbered 1 to 11). If so, readys the Fitness Frogs for
    * sprinting. Next requests the user for the number of repetitions via a dialogue
    * box. Then enters a loop whose length is equal to the number of repetitions.
    * On each iteration, gets each Fitness Frog to sprint in turn. Finally, announces
    * which of the Fitness Frogs has sprinted the furthest. Returns no value.
    */
    public void train()
    {
       int repetitions = 0;      

       this.getSporty1().resetTotalDistanceSprinted();
       this.getSporty2().resetTotalDistanceSprinted();
       repetitions = this.getNumberRepetitions();
       
       if ((this.isOnBlackStones(this.getSporty1()) && (this.isOnBlackStones(this.getSporty2()))))
       {
          for (int count = 1; count <= repetitions; count++)
          {
             this.getSporty1().sprint();
             this.getSporty2().sprint();
          }
          this.announceFittestFrog();
       }
    }
    
    /**
     * Helper, returns true if both Fitness Frogs are positioned on black stones, 
     * false otherwise.
     */
     private boolean isOnBlackStones(FitnessFrog aFitnessFrog)
     {
        return aFitnessFrog.getPosition() >= 1 && aFitnessFrog.getPosition() <= 11;
     }
}