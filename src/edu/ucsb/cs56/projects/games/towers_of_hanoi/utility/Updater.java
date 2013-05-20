package src.edu.ucsb.cs56.games.towers_of_hanoi.utility;


/** Class that main GUI can call to start up timer
 *  at the beginning of the game
 *  @author Shanen Cross
 */

public class Updater {

    // This assumes that we have a Timer with the methods indicated,
    // but as of now no one has implemented one yet

    /** Starts up timer, makes a listener (which has the callback),
     *  and passes it to the timer, which invokes the callback
     *  every n milliseconds
     * @param n  number of milliseconds; callback to be invoked
     */
    public static void Start(int n) {

	Timer a_timer = new Timer();
	TimerCallback callback = new UpdateGUITimer();
	Timer.RegisterEveryNMilliseconds(n);
    }
    
    // for potential testing
    public void go() {

    }
    
    // for potential testing
    public static void main(String[] args) {
	Updater a_updater = new Updater();
	a_updater.go()
    }

}
