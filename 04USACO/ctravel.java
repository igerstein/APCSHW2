import java.util.*;
public class ctravel{
    public static void main(String[]args){
	String input = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	Scanner sc = new Scanner(input);
	String line1 = sc.nextLine();
	int rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	int cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
    }
}
