import java.util.*;
import java.io.*;
public class ctravel{
    public static int rows;
    public static int cols;
    public static char[][] map;
    public static void main(String[]args){
	try{
	    File f = new File("ctravel.in");
	    Scanner sc = new Scanner(f);
	    String line1 = sc.nextLine();
	    rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	    cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
	    int time = Integer.parseInt(line1.substring(line1.lastIndexOf(" ") + 1));
	    map = new char[rows][cols];
	    for (int i = 0; i < rows; i++){
		String line = sc.nextLine();
		for (int j = 0; j < cols; j++){
		    map[i][j] = line.charAt(j);
		}
	    }
	    String lastline = sc.nextLine();
	    int r1 = Integer.parseInt(lastline.substring(0, lastline.indexOf(" "))) - 1;
	    int c1 = Integer.parseInt(lastline.substring(lastline.indexOf(" ") + 1, lastline.indexOf(" ", lastline.indexOf(" ") + 1))) - 1;
	    int r2 = Integer.parseInt(lastline.substring(lastline.indexOf(" ", lastline.indexOf(" ") + 1) + 1, lastline.lastIndexOf(" "))) - 1;
	    int c2 = Integer.parseInt(lastline.substring(lastline.lastIndexOf(" ") + 1)) - 1;
	    ctravel.solve(r1, c1, r2, c2, time);
	    System.out.println(ways);
	}catch (Exception e){
	    e.printStackTrace();
	}
    }

    static int ways = 0;
    public static boolean solve(int r1, int c1, int r2, int c2, int time){
	if (time < 0 || r1 < 0 || r1 >= rows || c1 < 0 || c1 >= cols || map[r1][c1] == '*'){
	    return false;
	}
	if (r1 == r2 && c1 == c2 && time == 0){
	    ways++;
	    return true;
	}
	solve(r1 + 1, c1, r2, c2, time - 1);
	solve(r1 - 1, c1, r2, c2, time - 1);
	solve(r1, c1 + 1, r2, c2, time - 1);
	solve(r1, c1 - 1, r2, c2, time - 1);
	return false;
    }
}
