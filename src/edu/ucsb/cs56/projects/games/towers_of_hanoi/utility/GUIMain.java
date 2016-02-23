package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.EventQueue;


import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

/**
 * Main class that launches a GUI version of Towers of Hanoi
 * @author Aaron
 *
 */

public class GUIMain {
    
    private static GameGUI gui;
    public static void main (String [] args){
	startGame();
    }
    
    public static void startGame() {
	
	// This allows us to restart the game without quitting the program
	if (gui != null){ // Is a replay, close the old game, clear the disks prompt, show it
	    gui.close();
	}
	
	// Contents of dialogue
	String[] options = {"Play"};
	JPanel panel = new JPanel();
	JLabel lbl = new JLabel("Number of Disks (3 to 25): ");
	JTextField txt = new JTextField(10);
	
	panel.add(lbl);
	panel.add(txt);
	
	int numberOfDisks = 0;
	JFrame frame = new JFrame();
	JOptionPane.showMessageDialog(frame,"Tower of Hanoi: \n\nThe goal of this game is to move all the disks from the leftmost tower to either the middle tower or rightmost tower, adhering to the following rules:\n   1) Move only one disk at a time.\n   2) A larger disk may not be placed ontop of a smaller disk.\n   3) All disks, except the one being moved, must be on a tower. \n\n                                                                                         Please press the OK button to continue");
	// Keep looping through the dialogue until a valid number is entered
	while (numberOfDisks > 25 || numberOfDisks < 3) {
	    
	    // Show the dialogue
	    int userResponse = JOptionPane.showOptionDialog(null, panel, "Towers of Hanoi", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
	    
	    if (userResponse == JOptionPane.CLOSED_OPTION) {
		
            	// User clicked the 'x' button
            	System.exit(0);
	    }
	    
	    // Try to parse the number they entered
	    try {
		numberOfDisks = Integer.parseInt(txt.getText());
	    } catch (NumberFormatException nf) {
		continue; // NaN -> show dialogue again
	    }
	}
	
	gui = new GameGUI();
	gui.setState(new TowersOfHanoiState(numberOfDisks));
    }
}
