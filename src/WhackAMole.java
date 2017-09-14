import java.util.Random;
import java.util.Scanner;

public class WhackAMole {

	int score;
	int molesLeft;
	//int numAttempts;
	int attemptsLeft;
	char[][] moleGrid;
	char[][] userGrid;
	
	int moleover;

	// methods
	WhackAMole(int numAttempts, int gridDimension) {
	//this.moleGrid = new char[gridDimension][gridDimension];
		//this.numAttempts = numAttempts;
		this.score=0;
		this.molesLeft=0;
		this.attemptsLeft= numAttempts;
		this.moleover=0;
		this.moleGrid= new char [gridDimension][gridDimension];
		this.userGrid= new char [gridDimension][gridDimension];
		
		for (int i=0; i<gridDimension;i++){
			for (int j=0; j<gridDimension;j++){
				this.moleGrid[i][j] = '*';
				this.userGrid[i][j] = '*';
			}
		}
	}

	boolean place(int x, int y) {
		if(moleGrid[x][y]!='M'){
		moleGrid[x][y] = 'M';
		molesLeft +=1;
		return true;
	}
		else{
			moleover+=1;
			return false;}
	}

	void whack(int x, int y) {
		
            userGrid[x][y]='W';
			if (moleGrid[x][y] == 'M') {
				score += 1;
				molesLeft -= 1;
				attemptsLeft -=1;
				moleGrid[x][y] = 'W';
			} else
				attemptsLeft -=1;
		}
	
		

	void printGridToUser() {
		for(int i=0;i<userGrid.length;i++){
			System.out.println(userGrid[i]);
		}
	}

	void printGrid() {
		for(int i=0;i<moleGrid.length;i++){
		System.out.println(moleGrid[i]);
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   //char [][] grid = new char [10][10]; 
   Scanner sc = new Scanner (System.in);
   WhackAMole obj = new WhackAMole(50,10);// attempts and grid dimensions
		
   // Generating random moles
		Random randomGenerator = new Random();
		for (int i = 0; i <10+obj.moleover; i++) {
			int ri = randomGenerator.nextInt(10);
			int rj = randomGenerator.nextInt(10);
		    obj.place(ri,rj);
		}
		
		
	// user coordinates to whack
		System.out.println("enter x and y coordinates to whack");
		for(int m=0;m<50;m++){
		int x=sc.nextInt();
		int y=sc.nextInt();
	
		
		if( (x == -1 && y == -1)) {
			obj.printGrid();
		  break;
		}
		obj.whack(x,y);
		obj.printGridToUser();
		if ((obj.molesLeft==0)|| (obj.attemptsLeft==0)) {
			break;
		}
		
		}
		
		sc.close();
	}
	}


