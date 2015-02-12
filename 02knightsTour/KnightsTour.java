import java.util.*;
import java.io.*;
public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String name(){
	return "Gerstein,Isaac";
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
        for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		if (board[i][j] < 10){
		    ans += "  " + board[i][j];
		} else if (board[i][j] < 100){
		    ans += " " + board[i][j];
		} else {
		    ans += board[i][j];
		}
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }

    public boolean solve(){
	return solve(0, 0);
    }

    public boolean solve(int startx, int starty){
	return (solve(startx, starty, 1));
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	if (currentMoveNumber == board.length * board.length + 1){
	    return true;
	}
	if (x >= board.length || x < 0 || y >= board.length || y < 0 || board[y][x] != 0){
	    return false;
	}
	board[y][x] = currentMoveNumber;
	if (solve(x - 1, y - 2, currentMoveNumber + 1) || solve(x - 2, y - 1, currentMoveNumber + 1) ||
	    solve(x + 1, y - 2, currentMoveNumber + 1) || solve(x + 2, y - 1, currentMoveNumber + 1) ||
	    solve(x + 2, y + 1, currentMoveNumber + 1) || solve(x + 1, y + 2, currentMoveNumber + 1) ||
	    solve(x - 2, y + 1, currentMoveNumber + 1) || solve(x - 1, y + 2, currentMoveNumber + 1)){
	    return true;
	}
	board[y][x] = 0;
	return false;
    }
}
