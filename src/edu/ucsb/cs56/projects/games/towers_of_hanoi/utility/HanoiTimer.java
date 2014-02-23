package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;


import java.util.Timer;
import java.util.TimerTask;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

/**
 Class that acts as a timer. Contains methods
 to start, restart, and stop.  Must be called with an applicable JLabel to update.
 */
public class HanoiTimer {
	private long startTime = 0;
	private JLabel timeLabel = null;
	private boolean stopped = true;
	
	public HanoiTimer(JLabel label) {
		timeLabel=label;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
               updateTimer();
            }
        }, 0, 1000);
        start();
	}
	
	public void updateTimer() {
		if(timeLabel != null) {
			this.SetTimeElapsedText();
		}
	}
	
	/**
	 * Stops the timer then restarts it.
	 */
	public void restart() { 
		this.stop();
		this.start();
	}
	
	/**
	 * Starts timer if it is not already running
	 */
	public void start() {
		if(!stopped)return;
		startTime = System.currentTimeMillis();
		stopped = false;
	}
	
	/**
	 * Stops processing of timer events
	 */
	public void stop() {
		stopped = true;
	}
	
	/**
	 * Sets the label text of the JLabel to the elapsed time in proper format
	 */
	public void SetTimeElapsedText() {
		if(stopped || (timeLabel == null))return;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(System.currentTimeMillis() - startTime);
		String time = String.format("%02d", gc.get(GregorianCalendar.MINUTE)) + ":" + String.format("%02d", gc.get(GregorianCalendar.SECOND));
		timeLabel.setText(time);
	}
  
}
