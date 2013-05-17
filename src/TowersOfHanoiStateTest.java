edu.ucsb.cs56.projects.games.towers_of_hanoi.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *The test class TowersOfHanoiStateTest for TowersOfHanoiState class.
 *@author Roeland Singer-Heinze
 *@version CS56, 13S, proj1
 *@see TowersOfHanoiState
 */


public class TowersOfHanoiStateTest{

    /**
     *Test no argument constructor TowersOfHanoiState.
     *Should initialize game with 3 starting disks.
     *@see TowersOfHanoiState#TowersOfHanoiState
     */

    @test public void noArgumentConstructorTest(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState();




    } 

    /**
     *Test constructor TowersOfHanoiState with argument for number of disks.
     *Should initialize game with number of disks specified.
     *@see TowersOfHanoiState#TowersOfHanoiState
     */

    @test public void constructorWithArgument1(){

    }


    @test public void constructorWithArgument2(){

    }

    /**
     *Test getIsGameSolved getter method which returns the boolean value isGameSolved
     *@see TowersOfHanoiState#getIsGameSolved
     */

    @test public void getIsGameSolved_Test(){


    }

    /**
     *Test getNumOfMoves getter method which returns the integer value numOfMoves.
     *@see TowersOfHanoiState#getNumOfMoves
     */

    @test public void getNumOfMoves_Test(){

    }

    /**
    *Test getTowers getter method which returns the ArrayList reference towers.
    *@see TowersOfHanoi#getTowers
    */

    @test public void getTowers_Test(){

    }


    /**
     *test isMoveLegal method (returns false if move is illegal)
     *@see TowersOfHanoiState#isMoveLegal
     */

    @test public void isMoveLegal_Test(){


	assertTrue( );

    }

    /**
     *test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
     */

    @test public void makeMove_Test(){

    }

    /**
     *test disksOnTower method, which returns an integer array of the disks on given tower.
     *@see TowersOfHanoiState#disksOnTower
     */

    @test public void disksOnTower_Test(){

    }

    /**
     *test toString method which returns an ASCII art representation of game state.
     *@see TowersOfHanoiState#toString
     */

    @test public void toString_Test(){

    }

    /**
     *test solved method which returns boolean value indicating if game is solved.
     *@see TowersOfHanoiState#solved
     */

    @test public void solved_Test(){

    }


}
