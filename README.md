# cs56-games-towers-of-hanoi

A command line towers of hanoi game---not just a simulation, but a GAME

![](http://i.imgur.com/T2eKHVT.png)

## Next steps:

(1) Implement a timer object in a separate package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility.

The timer is a separate thread that can be started and stopped like a stopwatch, and keeps track of how much time has elapsed.  Also have a method to 
read the current value on the stopwatch, 

~estimate: 180

(2) A swing GUI SwingHanoiJFrame and driver The JFrame that provides methods to "draw" the tower should go in package edu.ucsb.cs56.projects.games.towers_of_hanoi.view
 that provides the same functionality as CmdLineHanoi, but does so in a Swing gui, where users can click on the from tower and to tower.

* In the first version, the disk can just "disappear" from the old tower and be drawn on the new tower in one "frame change".  Read in Chapters 12/13 about how to make this happen as "one frame of animation" change.
* In a later more sophisticated version, the disk can move with smooth animation from one tower to the other.

The JFrame that provides methods to "draw" the tower should go in package edu.ucsb.cs56.projects.games.towers_of_hanoi.view

The main class SwingHanoi should go in edu.ucsb.cs56.projects.games.towers_of_hanoi.controller


~estimate: 360
