package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.util.Timer;
import java.util.TimerTask;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

/**
 * 
 * This is a timer class that will begin running as soon as it is created. A JLabel is required for it to display in format mm:ss
 * @author Aaron Wexler / amwexler
 */
public class HanoiTimer {
    private GregorianCalendar gc = new GregorianCalendar();
    private long startTime = 0;
    private long pauseTime = 0;
    private long eTime = 0;
    private JLabel timeLabel = null;
    private boolean stopped = true;
    private boolean paused = false;
    private boolean started = false;
    /**
     * Consructs a new HanoiTimer and starts the timer running.
     * @param label The label that will receive the formatted elapsed time.
     */
    public HanoiTimer(JLabel label) {
     timeLabel = label;
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
     * If stopped, the timer will restart. Otherwise, do nothing
     */
    public void start() {
       if(!stopped)return;
       startTime = System.currentTimeMillis();
       stopped = false;
       paused = false;
       started = true;
   }

    /**
     * Stops processing of timer events
     */
    public void stop() {
       stopped = true;	
    }

    public void pause() {
        started = false;

        if(paused == false)
        {
        pauseTime = System.currentTimeMillis() - startTime;
        }
        paused = true;

    }
    public void resume() {
        if(paused == true)
            eTime = System.currentTimeMillis() - startTime;
            stopped = false;
            paused = false;
    }

    /**
     * Sets the label text of the JLabel to the elapsed time in proper format
     */
    public void SetTimeElapsedText() {

        if(stopped == true || timeLabel == null)
            return;
        else if(paused == false && stopped == false && started == true){
            gc.setTimeInMillis(System.currentTimeMillis() - startTime);
        }
        else if(paused == true && stopped == false && started == false){
            System.out.println("pause = " + pauseTime);
            gc.setTimeInMillis(pauseTime);
        }
        else if(paused == false && stopped == false && started == false){
            System.out.println("eTime = " + eTime);
            System.out.println("pause = " + pauseTime);
            gc.setTimeInMillis(System.currentTimeMillis() - startTime - (eTime - pauseTime) );
            System.out.println(eTime - pauseTime);
        }

        String time = String.format("%02d", gc.get(GregorianCalendar.MINUTE)) 
        + ":" + String.format("%02d", gc.get(GregorianCalendar.SECOND));
        timeLabel.setText(time);

        // long time = gc.get(GregorianCalendar.MILLISECOND);
        // String timeString = String.format("%04d", gc.get(GregorianCalendar.MILLISECOND)/1000L);
        // timeLabel.setText(timeString);
    }
}


