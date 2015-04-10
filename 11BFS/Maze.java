import java.util.*;
import java.io.*;
public class Maze{
    public static void main(String[]args){
	Maze a = new Maze("data1.dat");
	a.solveBFS(true);
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
    private MyDeque<LinkedList<Coordinate>> deque;
    public void setstartx(int x){
	startx = x;
    }
    public void setstarty(int y){
	starty = y;
    }

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
		setstartx(i % maxx);
		setstarty(i / maxx);
	    }
	}
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < maxy; i++){
	    for (int j = 0; j < maxx; j++){
		ans += maze[j][i];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public String toString(boolean animate){ //do the funky character codes when animate is true
	if (animate){
	    String ans = "";
	    for(int i = 0; i < maxx * maxy; i++){
		if(i % maxx == 0 && i != 0){
		    ans += "\n";
		}
		char c =  maze[i % maxx][i / maxx];
		if(c == '#'){
		    ans += c;
		}else{
		    ans += c;
		}
	    }
	    return hide + go(0,0) + ans + "\n" + show;
	}else{
	    return toString();
	}
    }

    public void clearMaze(boolean print){
	LinkedList<Coordinate> list = new LinkedList<Coordinate>();
	if (deque.size() > 0){
	    list = deque.getFirst();
	}
	for (int i = 0; i < list.size(); i++){
	    Coordinate current = list.get(i);
	    int currentx = current.getx();
	    int currenty = current.gety();
	    if (maze[currentx][currenty] == 'x'){
		maze[currentx][currenty] = 'X';
	    }
	}
	for (int i = 0; i < maxx; i++){
	    for (int j = 0; j < maxy; j++){
		if (maze[i][j] == 'x'){
		    maze[i][j] = ' ';
		}
		if (maze[i][j] == 'X'){
		    maze[i][j] = 'x';
		}
	    }
	}
	if (print){
	    System.out.println(this.toString(true));
	}
    }
    
    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){
	deque = new MyDeque<LinkedList<Coordinate>>(false);
	Coordinate start = new Coordinate(startx, starty);
	LinkedList<Coordinate> startList = new LinkedList<Coordinate>();
	startList.add(start);
	deque.addLast(startList);
	while (deque.size() > 0){
	    if (animate){
		wait(20);
		System.out.println(this.toString(true));
	    }
	    LinkedList<Coordinate> currentList = deque.getFirst();
	    Coordinate current = currentList.getLast();
	    int currentx = current.getx();
	    int currenty = current.gety();
	    if (maze[currentx][currenty] == ' '){
		maze[currentx][currenty] = 'x';
	    }
	    deque.removeFirst();
	    if (maze[currentx + 1][currenty] == ' ' || maze[currentx + 1][currenty] == 'E'){
		Coordinate next = new Coordinate(currentx + 1, currenty);
		LinkedList<Coordinate> nextList = (LinkedList<Coordinate>)currentList.clone();
		nextList.addLast(next);
		deque.addLast(nextList);
		if (maze[currentx + 1][currenty] == 'E'){
		    clearMaze(animate);
		    return true;
		}
	    }
	    if (maze[currentx][currenty + 1] == ' ' || maze[currentx][currenty + 1] == 'E'){
		Coordinate next = new Coordinate(currentx, currenty + 1);
		LinkedList<Coordinate> nextList = (LinkedList<Coordinate>)currentList.clone();
		nextList.addLast(next);
		deque.addLast(nextList);
		if (maze[currentx][currenty + 1] == 'E'){
		    clearMaze(animate);
		    return true;
		}
	    }
	    if (maze[currentx - 1][currenty] == ' ' || maze[currentx - 1][currenty] == 'E'){
		Coordinate next = new Coordinate(currentx - 1, currenty);
		LinkedList<Coordinate> nextList = (LinkedList<Coordinate>)currentList.clone();
		nextList.addLast(next);
		deque.addLast(nextList);
		if (maze[currentx - 1][currenty] == 'E'){
		    clearMaze(animate);
		    return true;
		}
	    }
	    if (maze[currentx][currenty - 1] == ' ' || maze[currentx][currenty - 1] == 'E'){
		Coordinate next = new Coordinate(currentx, currenty - 1);
		LinkedList<Coordinate> nextList = (LinkedList<Coordinate>)currentList.clone();
		nextList.addLast(next);
		deque.addLast(nextList);
		if (maze[currentx][currenty - 1] == 'E'){
		    clearMaze(animate);
		    return true;
		}
	    }
	}
	clearMaze(animate);
	return false;
    }

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

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public class Coordinate{
	private int x, y;
	
	public Coordinate(int x, int y){
	    this.x = x;
	    this.y = y;
	}

	public int getx(){
	    return x;
	}

	public int gety(){
	    return y;
	}

	public String toString(){
	    return "(" + x + "," + y + ")";
	}
    }
}
