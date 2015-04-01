import java.util.*;
import java.io.*;
public class Maze{
    public static void main(String[]args){
	Maze a = new Maze("data1.dat");
	System.out.println(a);
    }

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private char[][] maze;
    private int startx, starty;
    private int maxx, maxy;

    /** Same constructor as before...*/
    public Maze(String filename){
	int startx = -1;
	int starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < maxx; i++){
	    for (int j = 0; j < maxy; j++){
		ans += maze[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    //public String toString(boolean animate); //do the funky character codes when animate is true

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    //public boolean solveBFS(boolean animate){    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    //public boolean solveDFS(boolean animate){    }

    // public boolean solveBFS(){
    //	return solveBFS(false);
    //  }
    //  public boolean solveDFS(){
    //	return solveDFS(false);
    //  }

    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    // public int[] solutionCoordinates(){
    //  }
    
}