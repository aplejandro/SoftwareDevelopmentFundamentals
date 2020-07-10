package Week1_HW;
import java.util.*;


public class WhackAMole {
	
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	
	/**
	 * Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
	 * After reading through the assignment
	 * make sure to initialize the moleGrid with the appropriate character.
	 */
	public WhackAMole(int numAttempts, int gridDimension){
		this.score = 0;
		this.molesLeft = 0;
		this.attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for(int i = 0; i < gridDimension; i++) {
			for(int j = 0; j < gridDimension; j++) {
				moleGrid[i][j] = '*';
			}
		}
	}
	/**
	 *Given a location, place a mole at that location.
	 *Return true if you can. (Also update number of moles left.)
	 */
	boolean place(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			return false;
		}else{
		moleGrid[x][y] = 'M';
		molesLeft ++;
		return true;
	}
	}
	/**
	 *Given a location, take a whack at that location. 
	 *If that location contains a mole, the score, number of attemptsLeft,
	 *and molesLeft is updated. 
	 *If that location does not contain a mole, only attemptsLeft is updated.
	 */
	void whack(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			moleGrid[x][y] = 'W';
			molesLeft --;
			score ++;
			attemptsLeft --;		
		}else {
			attemptsLeft --;	
		}
	}
	
	/**
	 *Print the grid without showing where the moles are. 
	 *For every spot that has recorded a “whacked mole,” print out a W, or * otherwise
	 */
	void printGridToUser() {
		for(char[] row : moleGrid) {
			for (char e : row ) {
			    if (e == 'W') {
					System.out.print("W");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 *Print the grid completely. This is effectively dumping the 2d array on the screen. 
	 *The places where the moles are should be printed as an ‘M’. 
	 *The places where the moles have been whacked should be printed as a ‘W’.
	 *The places that don’t have a mole should be printed as *.
	 */
	void printGrid() {
		for(char[] row : moleGrid) {
			for (char e : row ) {
				if (e == 'M')
				{
					System.out.print("M");					
				}else if (e == 'W') {
					System.out.print("W");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}	
	}
	
	/**
	 *Putting it all together - main method
      *In order to play this game you need to create a main method. 
      *Begin by creating a 10 by 10 grid where you randomly place the moles. Place a total of 10 moles.
      *Now allow the user (remember how to use Scanner?) to enter the x and y coordinates 
      *of where they would like to take a whack. 
      *Tell them they have a maximum of 50 attempts to get all the moles. 
      *At any point in the game, they can input coordinates of -1, -1 in order to indicate 
      *that they are giving up. If the user gives up they get to see the entire grid.  
      *The game ends if the user is able to uncover all the moles or if the user runs out of attempts. 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WhackAMole whackGame = new WhackAMole(50, 10);
		 Random random = new Random();
		 int i = 0;
		 while (i < 10) {
			 int x1 = random.nextInt(10);
			 int y1 = random.nextInt(10);
			 whackGame.place(x1,y1);	
			 i++;
			 //System.out.println("Placed: " + x1 + "," + y1);
			}
		 
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Welcome to my whackamole game");
		 
		 while (whackGame.molesLeft > 0 && whackGame.attemptsLeft > 0) {
			 
			 System.out.println("You have " + whackGame.attemptsLeft + " attempts left");
			 System.out.println("Score: " + whackGame.score);
			 
			 whackGame.printGridToUser();
			 System.out.println("Insert x value");
			 int x = scanner.nextInt();
			 System.out.println("Insert y value");
			 int y = scanner.nextInt();
			 
			 if (x < 0 || x > 9 || y < 0 || y > 9) {
				 if (x == -1 && y == -1) {
					 System.out.println("Game ended by the user... Printing the moles");
					 whackGame.printGrid();
					 break;
				 }else {
					 System.out.println("Coordinates must be between 0-9");
				 }
			 }else {
				 whackGame.whack(x,y);
			 }
			 
			 if(whackGame.molesLeft == 0) {
				 System.out.println("You won!");
				 break;
			 }if (whackGame.attemptsLeft == 0) {
				 System.out.println("0 attempts left...");
				 break;
			 }
			 
		 }
		 System.out.println("Game over");
		 
	}

}
