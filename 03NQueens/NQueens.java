import java.util.*;
import java.io.*;
public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "gerstein.isaac";
    }

    public NQueens(int size){
	board = new char[size][size];
    }

    public String toString(){
	String ans = "\n";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		ans += " " + board[i][j];
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
}