import java.awt.*;

import javax.swing.*;


public class Test {
	public static void main(String args[])
    {
		int numberOfPlayers = 5;
		Player[] players = new Player[numberOfPlayers];
	    for(int i = 0; i < numberOfPlayers; i++){
	      //create new panel to input the users name panel returns user name
	      //System.out.print("Player Name: ");
	    	//*************** need function in NumberOfPlayers to get player names
	    	// return the array of players? Or just one player
	      players[i] = new Player(i+1);
	      players[i].playerCard.totalScore = i *3;
	    }
 
            JFrame frame = new FinalScorecardPanel(players);
            //frame.setTitle("Space Balls Rules");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

    }
}