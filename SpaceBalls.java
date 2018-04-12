import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class SpaceBalls{
  public static void main(String[] args){
	  displayWelcome();
  }
  private static void displayWelcome(){
	  JFrame frame = new JFrame();
	  frame.setVisible(true);
	  frame.setSize(500,500);
	  JPanel welcomePanel = new JPanel();
	  frame.add(welcomePanel);
	  JLabel greetingMessage = new JLabel("SPACE BALLS");
	  welcomePanel.add(greetingMessage);
	  welcomePanel.setBackground(Color.blue);

	  JPanel buttons = new JPanel();
	  welcomePanel.add(buttons);
	  buttons.setBounds(50,100,95,30);
	  JButton playGame = new JButton("Start New Game");


	  playGame.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 welcomePanel.setBackground(Color.green);
	        	 Game spaceBalls = new Game(welcomePanel);
	         }
	      });

	  JButton rules = new JButton("Rules");
	  rules.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           //RulesFrame rules = new RulesFrame();
	        	 welcomePanel.setBackground(Color.red);
	         }
	      });
	  buttons.add(playGame);
	  buttons.add(rules);

  }
  public void actionPerformed(ActionEvent e) {

  }
}
