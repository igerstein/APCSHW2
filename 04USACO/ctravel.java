import java.util.*;
import java.io.*;
public class ctravel{
    public static void main(String[]args){
	try{
	    File f = new File("ctravel.in");
	    Scanner sc = new Scanner(f);
	    String line1 = sc.nextLine();
	    int rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	    int cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
	    int time = Integer.parseInt(line1.substring(line1.lastIndexOf(" ") + 1));
	    char[][] map = new char[rows][cols];
	    for (int i = 0; i < rows; i++){
		String line = sc.nextLine();
		for (int j = 0; j < cols; j++){
		    map[i][j] = line.charAt(j);
		}
	    }
	    String lastline = sc.nextLine();
	    int r1 = Integer.parseInt(lastline.substring(0, lastline.indexOf(" ")));
	    int c1 = Integer.parseInt(lastline.substring(lastline.indexOf(" ") + 1, lastline.indexOf(" ", lastline.indexOf(" ") + 1)));
	    int r2 = Integer.parseInt(lastline.substring(lastline.indexOf(" ", lastline.indexOf(" ") + 1) + 1, lastline.lastIndexOf(" ")));
	    int c2 = Integer.parseInt(lastline.substring(lastline.lastIndexOf(" ") + 1));
	    /*String str = "";
	      for (int i = 0; i < rows; i++){
	      for (int j = 0; j < cols; j++){
	      str += map[i][j] + " ";
	      }
	      str += "\n";
	    }
	    System.out.println(str);*/
	}catch (Exception e){
	    e.printStackTrace();
	}
    }
}
