import java.util.*;
import java.io.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private char[][] maze;
    private int[] solutionArray = new int[0];
    private int startx, starty;
    private int endx, endy;
    private int maxx, maxy;
    public void setstartx(int x){
	startx = x;
    }
    public void setstarty(int y){
	starty = y;
    }
    public void setendx(int x){
	endx = x;
    }
    public void setendy(int y){
	endy = y;
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
	    if (c == 'E'){
		setendx(i % maxx);
		setendy(i / maxx);
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
	    return clear + hide + go(0,0) + toString() + "\n" + show;
	}else{
	    return toString();
	}
    }

    public boolean solve(boolean animate, int mode){
	Frontier frontier = new Frontier(mode);
	Coordinate start = new Coordinate(startx, starty);
	LinkedList<Coordinate> startList = new LinkedList<Coordinate>();
	startList.add(start);
	frontier.add(startList);
	while (!frontier.isEmpty()){
	    if (animate){
		wait(50);
		System.out.println(this.toString(true));
	    }
	    LinkedList<Coordinate> currentList = frontier.remove();
	    Coordinate current = currentList.getLast();
	    int currentx = current.getx();
	    int currenty = current.gety();
	    if (maze[currentx][currenty] == ' '){
		maze[currentx][currenty] = 'x';
	    }
	    int nextx, nexty;
	    for (int i = 0; i < 4; i++){
		if (i == 0){
		    nextx = currentx + 1;
		    nexty = currenty;
		}else if (i == 1){
		    nextx = currentx;
		    nexty = currenty + 1;
		}else if (i == 2){
		    nextx = currentx - 1;
		    nexty = currenty;
		}else{
		    nextx = currentx;
		    nexty = currenty - 1;
		}
		if (maze[nextx][nexty] == ' ' || maze[nextx][nexty] == 'E'){
		    if (maze[nextx][nexty] == ' '){
			maze[nextx][nexty] = 'x';
		    }
		    Coordinate next = new Coordinate(nextx, nexty);
		    LinkedList<Coordinate> nextList = (LinkedList<Coordinate>)currentList.clone();
		    nextList.addLast(next);
		    frontier.add(nextList);
		    if (maze[nextx][nexty] == 'E'){
			tracePath(frontier);
			if (animate){
			    wait(50);
			    System.out.println(this.toString(true));
			}
			return true;
		    }
		}
	    }
	}
	if (animate){
	    wait(50);
	    System.out.println(this.toString(true));
	}
	return false;
    }
    
    public void tracePath(Frontier frontier){
	LinkedList<Coordinate> list = frontier.deque.getLast();
	solutionArray = new int[list.size() * 2];
	for (int i = 0; i < list.size(); i++){
	    Coordinate current = list.get(i);
	    int currentx = current.getx();
	    int currenty = current.gety();
	    solutionArray[i * 2] = currentx;
	    solutionArray[i * 2 + 1] = currenty;
	    if (maze[currentx][currenty] == 'x'){
		maze[currentx][currenty] = '@';
	    }
	}
    }

    public boolean solveBFS(boolean animate){
	return solve(animate, 0);
    }
   
    public boolean solveDFS(boolean animate){
	return solve(animate, 1);
    }

    public boolean solveBest(boolean animate){
	return solve(animate, 2);
    }

    public boolean solveAStar(boolean animate){
	return solve(animate, 3);
    }

    public boolean solveBFS(){
    	return solveBFS(false);
    }
    public boolean solveDFS(){
    	return solveDFS(false);
    }

    public boolean solveBest(){
	return solveBest(false);
    }

    public boolean solveAStar(){
	return solveAStar(false);
    }

    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){
	return solutionArray;
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public class Frontier{
	private MyDeque<LinkedList<Coordinate>> deque;
	private int mode; // 0 = BFS, 1 = DFS, 2 = Best, 3 = AStar

	public Frontier(int mode){
	    deque = new MyDeque<LinkedList<Coordinate>>(false);
	    this.mode = mode;
	}

	public void add(LinkedList<Coordinate> list){
	    if (mode == 0 || mode == 1){
		deque.addLast(list);
	    }else if (mode == 2){
		Coordinate current = list.getLast();
		deque.add(list, Math.abs(current.getx() - endx) + Math.abs(current.gety() - endy));
	    }else{
		Coordinate current = list.getLast();
		deque.add(list, Math.abs(current.getx() - endx) + Math.abs(current.gety() - endy) + list.size());
	    }
	}

	public LinkedList<Coordinate> remove(){
	    if (mode == 0){
		return deque.removeFirst();
	    }else if (mode == 1){
		return deque.removeLast();
	    }else{
		return deque.removeSmallest();
	    }
	}

	public boolean isEmpty(){
	    return deque.size() == 0;
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
