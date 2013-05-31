package edu.cs56.projects.games.towers_of_hanoi.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 class HanoiTimer that invokes threads to act as a timer. Contains methods
 to start, restart, and stop.  Must be called with an applicable JLabel to update.
 */
public class HanoiTimer {
	
	long MiliSeconds = 1000;
	long TimeElapsed = 0;
	private Thread MainTimerThread;
	private volatile boolean Continue = false;
	private volatile boolean Restart = false;
	private JLabel TimeOutput;
	private int ThreadRunning = 0;
	
	//POSSIBLY IMPLEMENT HanoiTimer
	//EveryNMilliseconds(n, time_label);
	//UpdateEveryNMilliseconds(1000);
	
	/**
	 HanoiTimer() no arg constructor.
	 */
	public HanoiTimer() {
		MiliSeconds = 1000;
		TimeElapsed = 0;
	}
	
	/**
	 HanoiTimer(long inputMiliSeconds) constructor that sets the delay between
	 Thread job completion (delay between how long "seconds" are).
	 */
	public HanoiTimer(long inputMiliSeconds) {
		TimeElapsed = 0;
		MiliSeconds = inputMiliSeconds;
	}
	
	/**
	 restart() restarts the "timer" thread at 0.
	 @param JLabel inputlabel JLabel passed in such that it can be formatted
	 for TimeElapsed.
	 */
	public void restart(JLabel inputLabel) {
		TimeOutput = inputLabel;
		Continue = true;
		Restart = true;
		
		ThreadRunning++;
		final int CurrentThread = ThreadRunning;
		
		TimeElapsed = 0;
		
		final Runnable Linker = new Runnable() {
			public void run() {
				SetTimeElapsedText(TimeOutput);
			}
		};
		
		MainTimerThread = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						while (Continue && Restart && ThreadRunning==CurrentThread) {
							SwingUtilities.invokeAndWait(Linker);
							Thread.sleep(MiliSeconds);
							IncrementTimeElapsed();
						}
					}
					Thread.sleep(100000000);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		MainTimerThread.start();
	}
	
	/**
	 start() Starts the "timer" thread and continues where it left off.
	 @param JLabel inputlabel JLabel passed in such that it can be formatted
	 for TimeElapsed.
	 */
	public void start(JLabel inputLabel) {
		TimeOutput = inputLabel;
		
		Continue = true;
		Restart = false;
		
		ThreadRunning++;
		final int CurrentThread = ThreadRunning;
		
		final Runnable Linker = new Runnable() {
			public void run() {
				SetTimeElapsedText(TimeOutput);
			}
		};
		
		MainTimerThread = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						while (Continue && !Restart && ThreadRunning==CurrentThread) {
							SwingUtilities.invokeAndWait(Linker);
							Thread.sleep(MiliSeconds);
							IncrementTimeElapsed();
						}
					}
					Thread.sleep(100000000);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		MainTimerThread.start();
	}
	
	/**
	 stop() Stops the "timer" threads active and acts as a stopped screen.
	 @param JLabel inputlabel JLabel passed in such that it can be formatted
	 for TimeElapsed.
	 */
	public void stop(JLabel inputLabel) {
		TimeOutput = inputLabel;
		
		Continue = false;
		Restart = false;
		
		final Runnable Linker = new Runnable() {
			public void run() {
				SetTimeElapsedText(TimeOutput);
			}
		};
		
		MainTimerThread = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						while (!Continue && !Restart) {
							SwingUtilities.invokeAndWait(Linker);
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		MainTimerThread.start();
	}
	
	/**
	 setTimeElapsedText(JLabel inputlabel) sets the current TimeElapsed on a
	 JLabel with proper formatting.
	 @param JLabel inputlabel JLabel passed in such that it can be formatted
	 for TimeElapsed.
	 */
	public void SetTimeElapsedText(JLabel inputLabel) {
		long tmp = TimeElapsed;
		long hours = 0;
		long mins = 0;
		long secs = 0;
		String Hrs;
		String Mins;
		String Secs;
		
		if (TimeElapsed >= 86400) {
			TimeElapsed = 0;
			tmp = TimeElapsed;
		}
		if (tmp < 86400 && tmp >= 3600) {
			hours = tmp/3600;
			tmp = tmp - hours*3600;
		}
		if (tmp < 3600 && tmp >= 60) {
			mins = tmp/60;
			tmp = tmp - mins*60;
		}
		if (tmp < 60 && tmp >= 0) {
			secs = tmp;
		}
		
		if (hours<10) {
			Hrs = "0" + hours;
		}
		else {
			Hrs = "" + hours;
		}
		if (mins < 10) {
			Mins = "0" + mins;
		}
		else {
			Mins = "" + mins;
		}
		
		if (secs < 10) {
			Secs = "0" + secs;
		}
		else {
			Secs = "" + secs;
		}
		
		inputLabel.setText(Hrs+":"+Mins+":"+Secs);
	}
	/**
	 IncrementTimeElapsed() increments TimeElapsed variable
	 */
	private synchronized void IncrementTimeElapsed(){
		TimeElapsed++;
	}
	
	/**
	 setTimeElapsed(long input)
	 @param long int input for nonmember access
	 */
	
	public void SetTimeElapsed(long input) {
		TimeElapsed = input;
	}
	
	/**
	 getTimeElapsed()
	 @return TimeElapsed private variable for nonmember access
	*/
	public long getTimeElapsed() { 
		return TimeElapsed; 
	}
	
   /* public static void main (String [] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
				new HanoiTimer();
            }
        });
	}*/
}
