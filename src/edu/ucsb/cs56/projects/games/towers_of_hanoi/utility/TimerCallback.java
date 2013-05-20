package src.edu.ucsb.cs56.games.towers_of_hanoi.utility;

import javax.swing.*;
import java.awt.event.*;

/**
 * TimerCallback class which contains a static method that can be called from anywhere which will
 * register a listener and its callback method with an event source.
 * @author Shanen Cross
 */
public class TimerCallback {

	/**
	 Called in order to register a listener and its callback with an event source
	*/
	public static void Register() { 
	
		
		/**
		 * 
		 */
		class TimerListener {
			public void callback(Object o) {
				ActionEvent e = (ActionEvent) o;
			// Handles whatever event is supposed to occur	
			}
			
		}
	}

	
	
	// for testing
	public void go() {
		
	}
	
	// for testing
	public static void main(String[] args) {
		
		TimerCallback t_callback = new TimerCallback();
		t_callback.go();
		
	}
}
