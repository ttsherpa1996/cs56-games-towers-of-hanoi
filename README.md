# cs56-games-towers-of-hanoi

project history
===============
```
 W14 | bkiefer13 5pm | amwexler | (jstaahl) A towers of hanoi GAME (not a solver or a simulation or an animation of the algorithm!)
```

A command line towers of hanoi game---not just a simulation, but a GAME

## Launching the Game

To launch the game using the command line, simply use the command:
```
ant run
```
When prompted by ant for the input-runargs, type in the number of starting disks you would like there to be and hit enter.


To launch the game using the GUI, simply use the command:
```
ant run-GUI
```

## Description

![](http://i.imgur.com/T2eKHVT.png)

At each step, the game displays an ASCII representation of the current state of the towers.
To move a disk from one tower to another, the user types in the start tower number and the end tower number separated by a space.

The game counts the user's moves. When the user completes the puzzle, the game tells the user how many moves it took him/her, as well as how many moves the optimal solution would have been.

//// A new description will be added for the GUI version ////
