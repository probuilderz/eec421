/*************************************
* File: mazeme.java
* Owner: Abou, Kevin, Thai
*
*
****************************************/
package abou.fofana;

import java.util.Scanner;

public class mazeme {
	
	private int rows;
	private int col;
	//private static char[][] maze;
	public mazeme(){
		this.rows= 10;
		this.col = 10;
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
	
	public void prn (char[][] maze){
		for(int i = 0; i< getRows(); i++){
			System.out.println();
			for(int j = 0; j< getCol(); j++)
				System.out.print(maze[i][j]);
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	char[][] maze; // = new char[rows][col];
		int rows;
		int col;
		 int rexit; // = rows-1;
		 int cexit; // = col;
		mazeme mazeObject = new mazeme();
		Scanner scan = new Scanner(System.in);
		System.out.print("enter number of row:");
		int r = scan.nextInt();
		System.out.print("\n enter number of col:");
		int c = scan.nextInt();
		mazeObject.setRows(r);
		mazeObject.setCol(c);
		//col = c;
		char[][] maze = new char[r][c];
		for(int i = 0; i< mazeObject.getRows(); i++)
			for(int j = 0; j< mazeObject.getCol(); j++)
				maze[i][j] = 'x';        // every space is a wall
		
		for( int i = 1; i<mazeObject.getRows()-1; i+=2)
			for(int j = 1; j<mazeObject.getCol() -1; j+=2)
				maze[i][j] = ' ';          // create a grid
		maze[1][1] = '@';                 // position of the object
		
		mazeObject.prn(maze);
		

	}
	
	
	
	
		


}
