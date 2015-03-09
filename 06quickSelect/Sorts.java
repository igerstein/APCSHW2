import java.util.*;
public class Sorts{
    public static void quicksort(int[] ary){
	if (ary.length > 1){
	    int si = 0;
	    int dup = 0;
	    int ei = ary.length - 1;
	    int randomIndex = (int)(Math.random() * (ei - si + 1)) + si;
	    int pivot = ary[randomIndex];
	    int temp;
	    while (dup <= ei){
		if (ary[dup] > pivot){
		    temp = ary[ei];
		    ary[ei] = ary[dup];
		    ary[dup] = temp;
		    ei--;
		}else if (ary[dup] == pivot){
		    dup++;
		}else{
		    temp = ary[dup];
		    ary[dup] = ary[si];
		    ary[si] = temp;
		    dup++;
		    si++;
		}
	    }

	    int[] section1 = new int[si];
	    for (int i = 0; i < section1.length; i++){
		section1[i] = ary[i];
	    }
	    quicksort(section1);
	    for (int i = 0; i < section1.length; i++){
		ary[i] = section1[i];
	    }
	    
	    int[] section2 = new int[ary.length - ei - 1];
	    for (int i = 0; i < section2.length; i++){
		section2[i] = ary[ei + i + 1];
	    }
	    quicksort(section2);
	    for (int i = 0; i < section2.length; i++){
		ary[ei + i + 1] = section2[i];
	    }
	}
    }
    
    public static int quickSelect(int[] ary, int n){
	int si = 0;
	int ei = ary.length - 1;
	int randomIndex = (int)(Math.random() * (ei - si + 1)) + si;
	int pivot = ary[randomIndex];
	int temp;
	while (si != ei){
	    if (ary[si] > pivot){
		temp = ary[ei];
		ary[ei] = ary[si];
		ary[si] = temp;
		ei--;
	    }else if (ary[si] == pivot){
		temp = ary[si + 1];
		ary[si + 1] = ary[si];
		ary[si] = temp;
	    }else{
		si++;
	    }
	}
	if (si == n){
	    return ary[si];
	}
	if (si > n){
	    int[] section = new int[si];
	    for (int i = 0; i < si; i++){
		section[i] = ary[i];
	    }
	    return quickSelect(section, n);
	}else{
	    int[] section = new int[ary.length - si - 1];
	    for (int i = 0; i < section.length; i++){
		section[i] = ary[si + i + 1];
	    }
	    return quickSelect(section, n - si - 1);
	}
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
