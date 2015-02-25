import java.util.*;
import java.io.*;
public class makelake{
    public static void main(String[]args){
	try{
	    File f = new File("makelake.in");
	    Scanner sc = new Scanner(f);
	    String line1 = sc.nextLine();
	    int rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	    int cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
	    int waterLevel = Integer.parseInt(line1.substring(line1.indexOf(" ", line1.indexOf(" ") + 1) + 1, line1.lastIndexOf(" ")));
	    int[][] elevations = new int[rows][cols];
	    for (int i = 0; i < rows; i++){
		String line = sc.nextLine();
		int spot = 0;
		for (int j = 0; j < cols; j++){
		    if (line.indexOf(" ", spot) < 0){
			elevations[i][j] = Integer.parseInt(line.substring(spot));
		    } else {
			elevations[i][j] = Integer.parseInt(line.substring(spot, line.indexOf(" ", spot)));
		    }
		    spot = line.indexOf(" ", spot) + 1;
		}
	    }
	    while (sc.hasNextLine()){
		String line = sc.nextLine();
		int pos1 = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		int pos2 = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(" ", line.indexOf(" ") + 1)));
		int stompLevel = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
		int maxLevel = 0;
		for (int i = pos1 - 1; i < pos1 + 2; i++){
		    for (int j = pos2 - 1; j < pos2 + 2; j++){
			if (elevations[i][j] > maxLevel){
			    maxLevel = elevations[i][j];
			}
		    }
		}
		for (int i = pos1 - 1; i < pos1 + 2; i++){
		    for (int j = pos2 - 1; j < pos2 + 2; j++){
			if (elevations[i][j] > maxLevel - stompLevel){
			    elevations[i][j] = maxLevel - stompLevel;
			}
		    }
		}
	    }
	    int totalDepth = 0;
	    for (int i = 0; i < rows; i++){
		for (int j = 0; j < cols; j++){
		    if (elevations[i][j] < waterLevel){
			elevations[i][j] = waterLevel - elevations[i][j];
		    } else {
			elevations[i][j] = 0;
		    }
		    totalDepth += elevations[i][j];
		}
	    }
	    int volume = totalDepth * 72 * 72;
	    System.out.println(volume);
	}catch (Exception e){
	    e.printStackTrace();
	}
    }
}
