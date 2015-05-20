import java.util.*;
public class Sorts{
    public static String name(){
	return "gerstein.isaac";
    }

    public static void heapsort(int[] ary){
	heapify(ary);
	for (int i = ary.length - 1; i > 0; i--){
	    int root = ary[0];
	    ary[0] = ary[i];
	    ary[i] = root;
	    int pos = 0;
	    while ((pos * 2 + 1 <= i - 1 && ary[pos] < ary[pos * 2 + 1]) || (pos * 2 + 2 <= i - 1 && ary[pos] < ary[pos * 2 + 2])){
		int next = 0;
		if ((pos * 2 + 1 <= i - 1 && ary[pos] < ary[pos * 2 + 1]) && (pos * 2 + 2 <= i - 1 && ary[pos] < ary[pos * 2 + 2])){
		    if (ary[pos * 2 + 1] < ary[pos * 2 + 2]){
			next = pos * 2 + 2;
		    }else{
			next = pos * 2 + 1;
		    }
		}else if (pos * 2 + 1 <= i - 1 && ary[pos] < ary[pos * 2 + 1]){
		    next = pos * 2 + 1;
		}else{
		    next = pos * 2 + 2;
		}
		int temp = ary[next];
		ary[next] = ary[pos];
		ary[pos] = temp;
		pos = next;
	    }
	}
    }

    public static void heapify(int[] ary){
	int[] newAry = new int[ary.length];
	for (int i = 0; i < ary.length; i++){
	    newAry[i] = ary[i];
	    int pos = i;
	    while ((pos + 1) / 2 - 1 >= 0 && newAry[pos] > newAry[(pos + 1) / 2 - 1]){
		int temp = newAry[(pos + 1) / 2 - 1];
		newAry[(pos + 1) / 2 - 1] = newAry[pos];
		newAry[pos] = temp;
		pos = (pos + 1) / 2 - 1;
	    }
	}
	for (int i = 0; i < ary.length; i++){
	    ary[i] = newAry[i];
	}
    }
}
