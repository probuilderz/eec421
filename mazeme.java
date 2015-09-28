package abou.fofana;

import java.util.Scanner;
import java.lang.Math;;

public class mazeme {

	private int rows;
	private int col;
	private char[][] maze;
	/*
	 * Constructors and functions
	 */
	public mazeme(){
		this.rows= 11;
		this.col = 11;
		this.maze = new char[rows][col];
	}
	public mazeme(int r, int c){
		this.rows = r;
		this.col = c;
		this.maze = new char[rows][col];
	}
	public char[][] getMaze(){
		return maze;
	}
	public void setMaze(char[][] m){
		this.maze = m;
	}
	public int getRows(){
		return rows;
	}
	public int getCol(){
		return col;
	}
	public void setRows(int r){
		this.rows = r;
	}
	public void setCol(int c){
		this.col = c;
	}

	/****************************************
	 * Function: prn()		print the maze
	 * @param maze
	 */
	public void prn (char[][] maze){
		for(int i = 0; i< getRows(); i++){
			System.out.println();
			for(int j = 0; j< getCol(); j++)
				System.out.print(maze[i][j]);
		}

		System.out.println();	
	}

	/****************************************
	 * Function: prn1() , this function is to print the position of walls
	 * @param m			: Array of rows of walls
	 * @param n			: Array of columns of walls
	 * @param r			: The count of walls
	 * Objective:		: for debugging purposes.
	 */
	public void prn1 (int[] m,int[] n,  int r){
		for(int i = 0; i< r; i++){
			//			System.out.println();
			System.out.print(" "+m[i]);
		}
		System.out.println();
		for(int i = 0; i< r; i++){
			//			System.out.println();
			System.out.print(" "+n[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	char[][] maze; // = new char[rows][col];
		int rows;
		int col;

		mazeme mazeObject = new mazeme();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Do you want to play (y) or (n): ");
		   String keep = scan.next().toLowerCase();
		  
		   boolean ans = false;
		   if (keep.equals("y")|| keep.equals("Y")){
			   ans = true;
		   }else{
			   ans = false;
			   System.exit(0);
		   }
		
		System.out.print("enter maze size L x L :");
		int r = scan.nextInt();
		//System.out.print("\n enter number of col:");
		//int c = scan.nextInt();

		if(r % 2 == 0){
			r++;
		}
		int c = r;
		mazeObject.setRows(r);
		mazeObject.setCol(c);
		//col = c;
		char empty= 30;
		/*Create a square maze where everything is wall */
		int i=0,j=0;
		int emptyCt = 0; // number of rooms
		int wallCt = 0;  // number of walls
		int[] wallrow = new int[(mazeObject.getRows()*mazeObject.getCol())/2];  // position of walls between rooms
		int[] wallcol = new int[(mazeObject.getRows()*mazeObject.getCol())/2];

		char[][] mazet = new char[r][c];
		for(i = 0; i< mazeObject.getRows(); i++)
			for(j = 0; j< mazeObject.getCol(); j++)
				mazet[i][j] = 'x';        // every space is a wall

		/* Initialize the starting point */

		for( i = 1; i<mazeObject.getRows()-1; i+=2)
			for(j = 1; j<mazeObject.getCol() -1; j+=2){
				empty++;
				mazet[i][j] = empty;          // create a grid, with ASCII characters inside			

				if (i < mazeObject.getRows()-2) {  // record info about wall below this room
					wallrow[wallCt] = i+1;
					wallcol[wallCt] = j;
					wallCt++;
				}
				if (j < mazeObject.getCol()-2) {  // record info about wall to right of this room
					wallrow[wallCt] = i;
					wallcol[wallCt] = j+1;
					wallCt++;
				}
			}
		mazeObject.prn1(wallrow, wallcol, wallCt);   // this display the walls position in the grid. 

		mazeObject.setMaze(mazet);
		//mazeObject.prn(mazeObject.getMaze());
		/* Create randoms wall*/
		int rt =0;
		for (int k=wallCt-1; k>0; k--) {
			rt = (int)(Math.random() * k);  // choose a wall randomly and maybe tear it down
			//            if (checkStatus() == TERMINATE)
			//               return;
			tearDown(wallrow[rt],wallcol[rt],mazeObject.getMaze());
			//			System.out.println("---");
			//			System.out.println(rt);
			//			System.out.println("---");
			//			System.out.println("---");
			//			System.out.println(wallrow[rt]);
			//			System.out.println("---");
			wallrow[rt] = wallrow[k];
			wallcol[rt] = wallcol[k];

			//			mazeObject.prn1(wallrow, wallcol, wallCt);

			//			mazeObject.prn(mazeObject.getMaze());
		}
		
		mazet = mazeObject.getMaze();
		
		// Replace all remaining characters that are not walls
		for(i =1; i<mazeObject.getRows()-1; i++)
			for(j =1; j<mazeObject.getRows()-1; j++){
				if(mazet[i][j] != 'x')
					mazet[i][j] = ' ';
			}
		mazet[1][0] = '@';                 // position of the object
		mazeObject.setMaze(mazet);


		solveMaze(1,1,mazet);
		
		
		//mazeObject.prn(mazeObject.getMaze());


	}

	private static void tearDown(int row, int col, char[][] m) {
		mazeme mazeObject1 = new mazeme(m.length,m.length);
		char[][] maze1 = new char[m.length][m.length];
		maze1 = m;
		//maze1 = mazeObject1.getMaze();
		//System.out.println("---");
		//mazeObject1.prn(maze1);
		// TODO Auto-generated method stub
		if (row % 2 == 1 && maze1[row][col-1] != maze1[row][col+1]) {
			// row is odd; wall separates rooms horizontally
			fill(row, col-1,mazeObject1.getMaze(), maze1[row][col-1], maze1[row][col+1]);
			maze1[row][col] = maze1[row][col+1];
			mazeObject1.setMaze(maze1);
			putSquare(row,col,mazeObject1.getMaze(),'c');
			//     try { wait(speedSleep); }
			//     catch (InterruptedException e) { }
		}
		else if (row % 2 == 0 && maze1[row-1][col] != maze1[row+1][col]) {
			// row is even; wall separates rooms vertically
			fill(row-1, col,mazeObject1.getMaze(), maze1[row-1][col], maze1[row+1][col]);
			maze1[row][col] = maze1[row+1][col];
			mazeObject1.setMaze(maze1);
			putSquare(row,col,mazeObject1.getMaze(),'c');
			//     try { wait(speedSleep); }
			//     catch (InterruptedException e) { }
		}

	}

	private static void putSquare(int row, int col,char[][] m, char c) {
		// TODO Auto-generated method stub
		char[][]maze= m;
		mazeme mazeObject1 = new mazeme(m.length, m.length);
		//maze = mazeObject1.getMaze();
		maze[row][col] = c;
		mazeObject1.setMaze(maze);
		//mazeObject1.prn(mazeObject1.getMaze());

	}

	private static void fill(int row, int col, char[][] m,char replace, char replaceWith) {
		// TODO Auto-generated method stub
		char[][]maze = m;
		mazeme mazeObject2 = new mazeme(m.length, m.length);
		//maze = mazeObject2.getMaze();

		if (maze[row][col] ==replace) {
			maze[row][col] = replaceWith;
			mazeObject2.setMaze(maze);
			fill(row+1,col,m,replace,replaceWith);
			fill(row-1,col,m,replace,replaceWith);
			fill(row,col+1,m,replace,replaceWith);
			fill(row,col-1,m,replace,replaceWith);
		}

	}

	private static boolean solveMaze(int row, int col, char[][]m) {
		// Try to solve the maze by continuing current path from position
		// (row,col).  Return true if a solution is found.  The maze is
		// considered to be solved if the path reaches the lower right cell.
		char[][] maze = m;
		mazeme mazeObject2 = new mazeme(m.length, m.length);
//		Thread mazeThread;   // thread for creating and solving maze
		int speedSleep = 50;

		if (maze[row][col] == ' ') {
			maze[row][col] = '@';      // add this cell to the path
			//      if (checkStatus() == TERMINATE)
			//         return false;
			putSquare(row,col,m,'@');
			mazeObject2.setMaze(m);
			mazeObject2.prn(mazeObject2.getMaze());
			if (row == mazeObject2.getRows()-2 && col == mazeObject2.getCol()-2)
				return true;  // path has reached goal
			try { Thread.sleep(speedSleep); }
			catch (InterruptedException e) { }
			if ( (solveMaze(row-1,col,m)) ||     // try to solve maze by extending path
					(solveMaze(row,col-1,m))   ||     //    in each possible direction
					(solveMaze(row+1,col,m))  ||
					solveMaze(row,col+1,m) )
				return true;
			//      if (checkStatus() == TERMINATE)
			//         return false;
			// maze can't be solved from this cell, so backtract out of the cell
			maze[row][col] = '0';   // mark cell as having been visited
			putSquare(row,col,m,'0');
			
			//      synchronized(this) {
			//        try { wait(speedSleep); }
			//        catch (InterruptedException e) { }
			//      }
			try {
				Thread.sleep(speedSleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//      if (checkStatus() == TERMINATE)
			//         return false;
		}
		
		return false;
	}








}
