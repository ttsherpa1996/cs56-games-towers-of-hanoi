# cs56-games-towers-of-hanoi

project history
===============
```
 YES | mastergberry | amwexler | (jstaahl) A towers of hanoi GAME (not a solver or a simulation or an animation of the algorithm!)

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

### ASCII Version

![](http://i.imgur.com/T2eKHVT.png)

#### Instructions for ASCII Version

At each step, the game displays an ASCII representation of the current state of the towers.
To move a disk from one tower to another, the user types in the start tower number and the end tower number separated by a space.

The game counts the user's moves. When the user completes the puzzle, the game tells the user how many moves it took him/her, as well as how many moves the optimal solution would have been.

### GUI Version

![](http://i.imgur.com/EENXRwP.png)

Instructional window pops up when running the GUI

![](http://i.imgur.com/yzU5bNN.png)

First, enter how many disks you want for each tower to have.  The minimum is 3.  When you have entered a valid number, click "Done".

![](http://i.imgur.com/l0ZIceQ.png)

If you make an illegal move, the game provides an alert. Tap the spacebar to dismiss it.

![](http://i.imgur.com/AHuwF0Z.jpg)

Upon completion, the game provides feedback.

![](http://i.imgur.com/40CfSXl.jpg)

#### Instructions for GUI Version

When the game starts, so will the timer.  Click on a tower to select its top disk and then click on another tower to move that disk there. Move all three disks to another tower to win the game.

GUI Audio
Because we included audio into the GUI version of this game, this game will not run through ssh but works perfectly fine on local computer or on CSIL computers (without ssh).
