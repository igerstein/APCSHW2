import java.util.*;
public class Sorts{

    public String name(){
	return "gerstein.isaac";
    }

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
    
    public static void mergesort(int[] array){
	int mid = array.length / 2;
	int[] a = new int[mid];
	int[] b;
	if (array.length % 2 == 0){
	    b = new int[mid];
	}else{
	    b = new int[mid + 1];
	}
	for (int i = 0; i < mid; i++){
	    a[i] = array[i];
	}
	for (int i = mid, c = 0; i < array.length; i++, c++){
	    b[c] = array[i];
	}
	if (!Sorts.isSorted(a)){
	    mergesort(a);
	}
	if (!Sorts.isSorted(b)){
	    mergesort(b);
	}
	int[] array2 = merge(a, b);
	for (int i = 0; i < array2.length; i++){
	    array[i] = array2[i];
	}
    }

    public static boolean isSorted(int[] array){
	for (int i = 0; i < array.length - 1; i++){
	    if (array[i] > array[i + 1]){
		return false;
	    }
	}
	return true;
    }
}
