import java.util.*;
public class QuickSelect{
    public static void main(String[]args){
	int[] ary = {6, 5, 2, 8, 7, 1, 4, 9, 0, 3};
	QuickSelect a = new QuickSelect();
	a.partition(ary, 0, 9);
    }
    public void partition(int[] ary, int si, int ei){
	int[] d = new int[ary.length];
	for (int i = 0; i < d.length; i++){
	    if (i < si || i > ei){
		d[i] = ary[i];
	    }
	}
	int start = si;
	int end = ei;
	int randomIndex = (int)(Math.random() * (ei - si + 1)) + si;
	int pivot = ary[randomIndex];
	for (int i = start; i <= end; i++){
	    if (i != randomIndex){
		if (ary[i] < pivot){
		    d[si] = ary[i];
		    si++;
		}else{
		    d[ei] = ary[i];
		    ei--;
		}
	    }
	}
	d[si] = pivot;
	for (int i = 0; i < d.length; i++){
	    ary[i] = d[i];
	}
    }
}