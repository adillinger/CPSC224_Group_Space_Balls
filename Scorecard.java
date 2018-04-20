/**
* This class scores a game of Yahtzee
* This class contains methods to sort the array, score the upper half and the lower half of the upperScoreCard
* and display the different lines of the scorecard and the score you would receive,
* find the maximum of a kind, the maximum straight, find a full house, total all the dice,
* display the dice, and display the final scorecard at the end of the game.
* CPSC 224-01, Spring 2018
* Programming Assignment #6
* class Scorecard.java

* @author Alana Dillinger

* @version v1.0 3/23/2018
*/

import java.util.*;

public class Scorecard {
  Scanner input = new Scanner(System.in);

  public Die[] finalDice;
  public int numberOfSides = 7;
  public int numberOfDice = 7;
  public int numberOfRolls = 7;

  private int smallStraight;
  private int largeStraight;

  private int[] upperCardScores;
  private boolean[] hasBeenScored;

  /**
  * Scorecard constructor stores an array of dice that contains the same dice
  * that are stored in the dice array in the Yahtzee class
  */
  public Scorecard(Die[] dice){
    finalDice = dice;
    // set everything to zero since nothing has yet been scored
    smallStraight = 0;
    largeStraight = 0;

    upperCardScores = new int[numberOfSides];
    hasBeenScored = new boolean[numberOfSides];
  }

  /**
  * Sorts the array of dice in ascending order
  */
  public void sortArray(){
    boolean swap;
    int temp;
    do
    {
       swap = false;
       for (int count = 0; count < numberOfDice-1; count++)
       {
          if (this.finalDice[count].getValue() > this.finalDice[count + 1].getValue())
          {
             temp = this.finalDice[count].getValue();
             this.finalDice[count].set(this.finalDice[count+1].getValue());
             this.finalDice[count + 1].set(temp);
             swap = true;
          }
       }
    } while (swap);
  }


  /**
  * Scores the upper half of the scorecard
  * The upper half contains counts of each separate number
  * Each line will only be displayed as an option if it has not yet been scored
  */
  public void upperScoreCard(){
    if(finalDice[0]==MERCURY) upperScoreCard[0] = 7;
    if(finalDice[0]==VENUS) upperScoreCard[1] = 8;
    if(finalDice[0]==MARS) upperScoreCard[2] = 9;
    if(finalDice[0]==JUPITER) upperScoreCard[3] = 10;
    if(finalDice[0]==SATURN) upperScoreCard[4] = 11;
    if(finalDice[0]==URANUS) upperScoreCard[5] = 12;
    if(finalDice[0]==NEPTUNE) upperScoreCard[6] = 13;
  }

  /**
  * Score the lower half of the scorecard
  * The lower half contains points for straights, full houses, etc.
  * Each score will only be displayed if it has not yet been filled in on the scorecard
  */

    if(smallStraight == 0){
      if (this.maxStraightFound() >= numberOfDice - 1){
        System.out.println("Score 30 on the 'Small Straight' line");
      }else
        System.out.println("Score 0 on the 'Small Straight' line");
    }

    if(largeStraight == 0){
      for(i = 0; i < numberOfSides; i++){
        if(finalDice[i] == 1){
          
        }
      }
    }

  /**
    * Finds the count for the die value that occurs the most
    * @return the number of dice of that value that occur
    */
  private int maxOfAKindFound(){
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <=numberOfSides; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < numberOfDice; diePosition++)
            {
                if (this.finalDice[diePosition].getValue() == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
  }

  /**
    * Finds the total of all the dice rolled by adding up all of the dice values
    * @return the total that was added up
    */
  private int totalAllDice(){
    int total = 0;
    for (int diePosition = 0; diePosition < numberOfDice; diePosition++)
    {
        total = total + this.finalDice[diePosition].getValue();
    }
    return total;
  }

  /**
    * Displays the array of dice on the screen
    */
  public void displayHand(){
    for(int i = 0; i < numberOfDice; i++){
      System.out.print(this.finalDice[i].getValue() + " ");
    }
  }


  /**
    * Displays the final score card once the game has finished
    * Adds up all of the points on the card and displays the total at the bottom
    */
  public void displayScorecard(){
    int totalScore = 0;

    System.out.println("    FINAL SCORECARD");
    System.out.println("--------------------------");
    // UPPER SCORECARD
    for (int i = 0; i < numberOfSides; i++){
      System.out.println((i + 1) + "'s: " + upperCardScores[i]);
      totalScore = totalScore + upperCardScores[i];
    }

    // LOWER SCORECARD
    // 3 of a kind line
    if(threeOfAKind > 0){
      System.out.println(numberOfDice - 2 + " of a Kind: " + threeOfAKind);
      totalScore += threeOfAKind;
    }else{
      System.out.println(numberOfDice - 2 + " of a Kind: 0");
    }
    // 4 of a kind line
    if(fourOfAKind > 0){
      System.out.println(numberOfDice - 1 + " of a Kind: " + fourOfAKind);
      totalScore += fourOfAKind;
    }else{
      System.out.println(numberOfDice - 1 + " of a Kind: 0");
  }


   // small straight line
   if(smallStraight > 0){
     System.out.println("Small Straight: " + smallStraight);
     totalScore += smallStraight;
   }else{
     System.out.println("Small Straight: 0");
   }

   // large straight line
   if(largeStraight > 0){
     System.out.println("Large Straight: " + largeStraight);
     totalScore += largeStraight;
   }else{
     System.out.println("Large Straight: 0");
   }

   // Yahtzee line
   if(yahtzee > 0){
     System.out.println("Yahtzee: " + yahtzee);
     totalScore += yahtzee;
   }else{
     System.out.println("Yahtzee: 0");
   }

  // Display total score
  System.out.println("TOTAL SCORE: " + totalScore);
  }
}
