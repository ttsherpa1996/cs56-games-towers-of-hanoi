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
	ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>(3);
	towers.add(0, new ArrayList<Integer>({0, 1, 2}));
	towers.add(1, new ArrayList<Integer>(3));
	towers.add(2, new ArrayList<Integer>(3));

	assertEquals(towers, letsPlay.getTowers());

    } 

    /**
     *Test constructor TowersOfHanoiState with argument for number of disks.
     *Should initialize game with number of disks specified.
     *@see TowersOfHanoiState#TowersOfHanoiState
     */

    @test public void constructorWithArgument1(){
        TowersOfHanoiState letsPlay = new TowersOfHanoiState(-5);
        towers.add(0, new ArrayList<Integer>({0, 1, 2}));
        towers.add(1, new ArrayList<Integer>(3));
        towers.add(2, new ArrayList<Integer>(3));

        assertEquals(towers, letsPlay.getTowers());
    }

    /**
     *Test constructor TowersOfHanoiState with argument for number of disks.
     *Should initialize game with number of disks specified.
     *@see TowersOfHanoiState#TowersOfHanoiState
     */


    @test public void constructorWithArgument2(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
        towers.add(0, new ArrayList<Integer>({0, 1, 2, 3, 4}));
        towers.add(1, new ArrayList<Integer>(5));
        towers.add(2, new ArrayList<Integer>(5));

        assertEquals(towers, letsPlay.getTowers());
    }

    /**
     *Test getIsGameSolved getter method which returns the boolean value isGameSolved
     *@see TowersOfHanoiState#getIsGameSolved
     */

    @test public void getIsGameSolved_Test(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	assertFalse(letsPlay.getIsGameSolved());
    }

    /**
     *Test getNumOfMoves getter method which returns the integer value numOfMoves.
     *@see TowersOfHanoiState#getNumOfMoves
     */

    @test public void getNumOfMoves_Test(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
	assertEquals(letsPlay.getNumOfMoves(), 0);
    }


    /**
     *test isMoveLegal method (returns false if move is illegal)
     *@see TowersOfHanoiState#isMoveLegal
     */

    @test public void isMoveLegal_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	boolean aMove = letsPlay.isMoveLegal(0, 2);
	assertTrue(aMove);
    }

    /**
     *test isMoveLegal method (returns false if move is illegal)
     *@see TowersOfHanoiState#isMoveLegal
     */

    @test public void isMoveLegal_Test2(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	letsPlay.makeMove(0, 2);
        boolean aMove = letsPlay.isMoveLegal(0, 2);
        assertFalse(aMove);
    }


    /**
     *test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
     */

    @test public void makeMove_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	letsPlay.makeMove(0, 2);
	ArrayList tower1 = new ArrayList<Integer>({1,2});
	ArrayList tower2 = new ArrayList<Integer>({0});

	assertEquals(tower1, letsPlay.getTowers.get(0));
	assertEquals(tower2, letsPlay.getTowers.get(2));

    }

    /**
     *test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
     */

    @test public void makeMove_Test2(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
        letsPlay.makeMove(0, 2);
	letsPlay.makeMove(0, 1);
        ArrayList tower1 = new ArrayList<Integer>({2, 3, 4});
        ArrayList tower2 = new ArrayList<Integer>({0});

        assertEquals(tower1, letsPlay.getTowers.get(0));
        assertEquals(tower2, letsPlay.getTowers.get(2));

    }

    /**
     *test disksOnTower method, which returns an integer array of the disks on given tower.
     *@see TowersOfHanoiState#disksOnTower
     */

    @test public void disksOnTower_Test(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	int arr[] tower1 = letsPlay.diskOnTowers(0);
 
	int arr[] testArray = {0, 1, 2, 3, 4};

	assertEquals(tower1, testArray);

    }

    /**
     *test toString method which returns an ASCII art representation of game state.
     *@see TowersOfHanoiState#toString
     */

    @test public void toString_Test1(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState();

	String testString = "    |    \t    |    \t    |    \n"
                          + "   =|=   \t    |    \t    |    \n"
                          + "  ==|==  \t    |    \t    |    \n"
                          + " ===|=== \t    |    \t    |    \n"
                          + "----+----\t----+----\t----+----\n"
	                  + "    0    \t    1    \t    2    \n";

	assertEquals(testString, letsPlay.toString());
		     
    }

    /**
     *test toString method which returns an ASCII art representation of game state.
     *@see TowersOfHanoiState#toString
     */

    @test public void toString_Test1(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(0, 1);
        String testString = "      |      \t      |      \t      |      \n"
                          + "      |      \t      |      \t      |      \n"
                          + "      |      \t      |      \t      |      \n"
                          + "   ===|===   \t      |      \t      |      \n"
                          + "  ====|====  \t      |      \t      |      \n"
                          + " =====|===== \t    ==|==    \t     =|=     \n"
                          + "------+------\t------+------\t------+------\n"
	                  + "      0      \t      1      \t      2      \n";

        assertEquals(testString, letsPlay.toString());
		     

    }    

    /**
     *test solved method which returns boolean value indicating if game is solved.
     *@see TowersOfHanoiState#solved
     */

    @test public void solved_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	assertFalse(letsPlay.solved());

    }


    /**
     *test solved method which returns boolean value indicating if game is solved.
     *@see TowersOfHanoiState#solved
     */

    @test public void solved_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();

        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(0, 1);
	letsPlay.makeMove(2, 1);
        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(1, 0);
        letsPlay.makeMove(1, 2);
        letsPlay.makeMove(0, 2);

        assertTrue(letsPlay.solved());

    }


}
