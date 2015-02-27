import java.util.*;
public class MergeSort{
    public static int[] merge(int[] a, int[] b){
	int aSpot = 0;
	int bSpot = 0;
	int[] c = new int[a.length + b.length];
	while (aSpot < a.length && bSpot < b.length){
	    if (a[aSpot] < b[bSpot]){
		c[aSpot + bSpot] = a[aSpot];
		aSpot++;
	    }else{
		c[aSpot + bSpot] = b[bSpot];
		bSpot++;
	    }
	}
	if (bSpot == b.length){
	    while (aSpot < a.length){
		c[aSpot + bSpot] = a[aSpot];
		aSpot++;
	    }
	}else if (aSpot == a.length){
	    while (bSpot < b.length){
		c[aSpot + bSpot] = b[bSpot];
		bSpot++;
	    }
	}
	return c;
    }
    public static void main(String[]args){
	int[] a = {2, 3, 5};
	int[] b = {2, 4, 7, 9};
	int[] c = merge(a, b);
	System.out.println(Arrays.toString(c));
    }
}