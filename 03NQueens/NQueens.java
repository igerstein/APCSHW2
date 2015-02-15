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
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = '_';
	    }
	}
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

    public boolean solve(){
	return solve(0, 0);
    }

    public boolean solve(int x){
	return solve(0, x);
    }

    public boolean solve(int x, int y){
	if (x == board.length){
	    return true;
	}
	if (y == board.length || findQueens(x, y)){
	    return false;
	}
	board[y][x] = 'Q';
	for (int i = 0; i < board.length; i++){
	    if (solve(x + 1, i)){
		return true;
	    }
	}
	board[y][x] = '_';
	if (solve(x, y + 1)){
	    return true;
	}
	return false;
    }

    public boolean findQueens(int x, int y){
	for (int i = 0; i < board.length; i++){
	    if (board[y][i] == 'Q' && i != x){
		return true;
	    }
	    if (board[i][x] == 'Q' && i != y){
		return true;
	    }
	}
	int i = 0;
	int j = 0;
	if (y > x){
	    i = y - x;
	} else {
	    j = x - y;
	}
	while (i < board.length && j < board.length){
	    if (board[i][j] == 'Q' && i != y && j != x){
		return true;
	    }
	    i++;
	    j++;
	}
	i = board.length - 1;
	j = 0;
	if (x + y < board.length - 1){
	    i = x + y;
	} else {
	    j = x + y - board.length + 1;
	}
	while (i >= 0 && j < board.length - 1){
	    if (board[i][j] == 'Q' && i != y && j != x){
		return true;
	    }
	    i--;
	    j++;
	}
	return false;
    }
}
