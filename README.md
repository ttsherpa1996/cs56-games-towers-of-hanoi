cs56-games-towers-of-hanoi
==========================

A towers of hanoi game---not just a simulation, but a GAME (see readme)


There are MANY implementations of "solving" Towers of Hanoi in Java on the web, so making one of those is NOT really worth any 
points at all.

However, what is probably NOT easy to find is a GAME based on Towers of Hanoi,implemented in true MVC fashion.  The game is a 
race against time where a human has to solve the game, and the computer keeps track of whether moves are legal or not,
and how long it takes to solve.

To emphasize again: you are NOT implementing a Tower of Hanoi simulation where the "solving algorithm" is run in real time and you just watch the disks moving by themsselves.  That has "been done", many times.  This is DIFFERENT.

Here is what is needed:

(1) A TowersOfHanoiState class that "models" the Towers of Hanoi, with NO input or output---just:

* private objects that represent the game state (i.e. which towers are on which disks), whether the game has been solved yet, and how many moves the user has made so far---and nothing more.
* a method to inquire whether a given "proposed" move is legal or not (input: index of from tower and to tower)
* a method to make a move (and have an TowersOfHanoiIllegalMoveException thrown if the move is not legal) (input: index of from tower and to tower.)
* methods to inquire about what disk are on which towers (e.g. given a tower, return an int [] with the disk numbers)
* a method that returns an ASCII art representation of the towers as a string (complete with new lines)
 * see example below.
* a boolean method "solved" that returns true only when the puzzle is solved (i.e. all disks are stacked correctly on the destination peg.)
* JUnit tests to check whether the methods above work properly
 
Here's an example of what the ASCII art might look like for a starting position with three disks

```
      |                       |                       |
     =|=                      |                       |
    ==|==                     |                       |
   ===|===                    |                       |
  ----+----               ----+----               ----+----
      0                       1                       2
```

You aren't bound by that picture---if you find a better way to represent the state with ASCII art, go for it.

You will probably find it easier if you number the towers 0,1,2 and the disks 0,1,2,n-1 but that's up to you.

Put this TowersOfHanoiState class and TowersOfHanoiStateTest class in package edu.ucsb.cs56.projects.games.towers_of_hanoi.model

This includes setting up a build.xml, lib subdirectory for JUnit etc. and having good Javadoc comments on EVERY method.

If you can find an open source implementation of Towers of Hanoi, you are permitted--in fact strongly encouraged, to use or reuse elemnents of that code, PROVIDED you give proper credit and link back to the original source material in comments.

~estimate: 240

(2) A command line interface CmdLineHanoi that:

* takes one command line parameter, the number of disks (a number >= 1).
* creates an instance of the TowerOfHanoiState object
* goes into a loop what "while game is not yet solved"
 * prints the state of the towers on System.out
 * asks for a "from tower and to tower" as a string on System.in, as integers separated by whitespace, e.g. "0 2" or "1 3"
  * If the format is incorrect, ask user to try again, otherwise convert to a pair of ints
  * checks if the move would be legal--if so make the move, if not print a message "illegal move"
* when the game is solved and the loop is exited, print the final state of the towers with a message that the puzzle is solved, how many steps it took, what the optimal number of steps would have been (2^n -1).

Put this CmdLineHanoi class in package edu.ucsb.cs56.projects.games.towers_of_hanoi.view

~estimate: 120

(3) A swing GUI SwingHanoiJFrame and driver The JFrame that provides methods to "draw" the tower should go in package edu.ucsb.cs56.projects.games.towers_of_hanoi.view
 that provides the same functionality as CmdLineHanoi, but does so in a Swing gui, where users can click on the from tower and to tower.

* In the first version, the disk can just "disappear" from the old tower and be drawn on the new tower in one "frame change".  Read in Chapters 12/13 about how to make this happen as "one frame of animation" change.
* In a later more sophisticated version, the disk can move with smooth animation from one tower to the other.

The JFrame that provides methods to "draw" the tower should go in package edu.ucsb.cs56.projects.games.towers_of_hanoi.view

The main class SwingHanoi should go in edu.ucsb.cs56.projects.games.towers_of_hanoi.controller


~estimate: 360

(4) Implement a timer object in a separate package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility.

The timer is a separate thread that can be started and stopped like a stopwatch, and keeps track of how much time has elapsed.  Also have a method to 
read the current value on the stopwatch, 


~estimate: 180

Modify both the commmand line interface and the Swing gui so that in addition to keeping track of the number of moves, it can also keep track of the elapsed time.

(5) Add a feature to register a callback method that will get invoked every n milliseconds while the clock is running
* a void function that can be passed an Object o
 * The Object o inside can be cast to whatever is expected by the callback)
 * That Object contains whatever state the callback needs to do its work (e.g. references to Swing Widgets that need to be updated)
 
Use that new feature to add a "timer" that shows the elapsed time every second in the Swing gui version of the game.


~estimate: 180
