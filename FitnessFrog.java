import ou.*;
import java.util.Random;

/**
 * FitnessFrog objects are like Frog objects except that when
 * sprinting, they move a random number of stones (between 2 and 5
 * inclusive) in a rightward direction.
 * 
 * @author (M250 MT)
 * @version (1.0)
 */
public class FitnessFrog extends Frog
{
   // instance variable
   private int totalDistanceSprinted;
   private Random randomNumber;
   
   // constructor
   /**
    * Constructor for objects of class FitnessFrog.
    */
   public FitnessFrog()
   {
      super();
      this.randomNumber = new Random();      
      this.totalDistanceSprinted = 0;
   }

   /**
    * Setter for totalDistanceSprinted.
    */
   private void setTotalDistanceSprinted(int aValue)
   {
      this.totalDistanceSprinted = aValue;
   }

   /**
    * Getter for totalDistanceSprinted.
    */
   public int getTotalDistanceSprinted()
   {
      return this.totalDistanceSprinted;
   }      
   
   /**
    * Sets the value of the totalDistanceSprinted variable to 0.
    * Returns no value.
    */
   public void resetTotalDistanceSprinted()
   {
      this.setTotalDistanceSprinted(0);
   }

   /**
    * Returns a random integer value specifying a sprint length 
    * between 2 and 5 inclusive.
    */
   private int getSprintLength()
   {
      return (this.randomNumber.nextInt(4) + 2);
   }      
      
   /**
    * Saves the colour of the receiver, then sets the colour of the receiver to red 
    * and gets a sprint length. Next enters a loop and on each iteration does the 
    * following: first, checks if the receiver is on the last stone (numbered 11)
    * in which case moves the receiver to the first stone (numbered 1), otherwise
    * moves the receiver right; then increments the total distance sprinted. Upon 
    * exit from the loop, casues the receiver to jump once and then resets its colour.
    * Returns no value.
    */
   public void sprint()
   {
      OUColour originalColour = this.getColour();
      int sprintLength = 0;
      
      this.setColour(OUColour.RED);
      sprintLength = this.getSprintLength();
      for (int count = 0; count < sprintLength; count++)
      {
         if (this.getPosition() == 11)
         {
            this.setPosition(1);
         }
         else
         {
            this.right();
         }
         this.setTotalDistanceSprinted(this.getTotalDistanceSprinted() + 1);         
      }
      this.jump();
      this.setColour(originalColour);
   }
}