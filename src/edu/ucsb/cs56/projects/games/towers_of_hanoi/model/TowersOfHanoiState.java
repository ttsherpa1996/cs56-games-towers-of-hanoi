package edu.ucsb.cs56.projects.games.towers_of_hanoi.model;
import java.util.ArrayList;
import java.util.Arrays;

/** TowersOfHanoiState models the state of a game based on Towers of Hanoi.


 */


public class TowersOfHanoiState{


    private boolean isGameSolved = false;
    private int numOfMoves = 0;
    private ArrayList<ArrayList<Integer>> towers 
	= new ArrayList<ArrayList<Integer>>(3); //the 3 towers and their disks will be stored here


    /**
     *Inner class, defining a specific exception for TowersOfHanoiState where move is illegal
     */

    public static class TowersOfHanoiIllegalMoveException extends Exception{

	public TowersOfHanoiIllegalMoveException(){}
    
	public TowersOfHanoiIllegalMoveException(String message){

	    super(message);
	}

	public TowersOfHanoiIllegalMoveException(Throwable cause){

	    super(cause);
	}

    }


    /**
     *No argument constructor which initializes a game starting with 3 disks.
     */

    public TowersOfHanoiState(){

	towers = new ArrayList<ArrayList<Integer>>(); //stub

    }

    /**
     *TowersOfHanoiState constructor with argument for number of disks.
     *Should initialize game with number of disks specified.
     *@param numOfDisks is an integer number specifying number of disks for game
     */

    public TowersOfHanoiState(int numOfDisks){

	if (numOfDisks <= 3 ){ // Want a minimum of 3 disks

	    towers = new ArrayList<ArrayList<Integer>>(); //stub

	}

	else { // else user input is number of disks

	    towers = new ArrayList<ArrayList<Integer>>(); //stub

	}

    }

    /**
     *Getter method which returns the boolean value isGameSolved
     *@return boolean value isGameSolved in TowersOfHanoiState
     */

    public boolean getIsGameSolved(){

	return false; //stub
    }

    /**
     *Getter method which returns the integer value numOfMoves.
     *@return integer value numOfMoves in TowersOfHanoiState
     */

    public int getNumOfMoves(){

	return -1; // stub
    }


    /**
     *Getter method which returns the ArrayList reference towers.
     *@return ArrayList value towers in TowersOfHanoiState
     */

    public ArrayList<ArrayList<Integer>> getTowers(){

	return new ArrayList<ArrayList<Integer>>(); //stub

    }

    /**
     *Given the index of two towers, this  method determines whether a given move is legal.
     *@param indexFromTower is an integer representing which tower you want to move a disk from.
     *@param indexToTower is an integer representing which tower you want to move a disk to.
     *@return boolean value true if move is legal, false if illegal.
     */


    public boolean isMoveLegal(int indexFromTower, int indexToTower){


	return false; //Stub, needs implementation
    }

    /**
     *Given the index number of two towers, this method will move the top disk from one tower to the other.
     *Throws input/output exception if move is illegal.
     *@param indexFromTower is an integer representing which tower you want to move a disk from.
     *@param indexToTower is an integer representing which tower you want to move a disk to.
     */

    public void makeMove(int indexFromTower, int indexToTower) throws TowersOfHanoiIllegalMoveException {


    }

    /**
     *Given a tower, this method returns an array with the disk numbers on the tower.
     *@param tower is an ArrayList which contains the disks on the tower
     *@return an integer array containing the disks of the given tower
     */

    public int [] disksOnTower(ArrayList<Integer> tower){


	int [] arr = {-1};
	return arr; //stub, fix it
    }

    /**
     *A toString method that returns an ASCII art representation of the towers as a string.
     *@return a String that represents the game state complete with newline characters.
     */

    public String toString(){

	return ""; //stub, fix it
    }

    /**
     *This is a method to determine whether the game has been solved yet.
     *@return a boolean value true if game is solved, false otherwise.
     */

    public boolean solved(){

	return false; // stub, fix it
    }



}
