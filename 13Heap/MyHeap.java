import java.util.*;
import java.lang.*;
public class MyHeap{
    private int[] heap;
    private boolean isMax;

    public String name(){
	return "gerstein.isaac";
    }
    
    public MyHeap(){
	heap = new int[10];
	isMax = true;
    }

    public MyHeap(boolean isMax){
	heap = new int[10];
	this.isMax = isMax;
    }

    public String toString(){
	//return Arrays.toString(heap);
	String ans = "";
	int height = (int)(Math.log(heap[0]) / Math.log(2));
	int maxRowLen = (int)Math.pow(2, height) * 4;
	int index = 1;
	for (int i = 0; i <= height; i++){
	    int rowSpaceLen = maxRowLen / (int)Math.pow(2, i + 1);
	    for (int l = 0; l < rowSpaceLen - Math.pow(2, height - i); l++){
		ans += " ";
	    }
	    for (int j = 0; j < Math.pow(2, i) && index <= heap[0]; j++){
		ans += heap[index];
		index++;
		for (int k = 0; k < rowSpaceLen; k++){
		    ans += " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public int remove(){
	if (heap[0] == 0){
	    throw new NoSuchElementException();
	}
	int root = heap[1];
	heap[1] = heap[heap[0]];
	heap[heap[0]] = 0;
	heap[0]--;
	int pos = 1;
	if (isMax){
	    while ((pos * 2 <= heap[0] && heap[pos] < heap[pos * 2]) || (pos * 2 + 1 <= heap[0] && heap[pos] < heap[pos * 2 + 1])){
		int next = 0;
		if ((pos * 2 <= heap[0] && heap[pos] < heap[pos * 2]) && (pos * 2 + 1 <= heap[0] && heap[pos] < heap[pos * 2 + 1])){
		    if (heap[pos * 2] < heap[pos * 2 + 1]){
			next = pos * 2 + 1;
		    }else{
			next = pos * 2;
		    }
		}else if (pos * 2 <= heap[0] && heap[pos] < heap[pos * 2]){
		    next = pos * 2;
		}else{
		    next = pos * 2 + 1;
		}
		int temp = heap[next];
		heap[next] = heap[pos];
		heap[pos] = temp;
		pos = next;
	    }
	}else{
	    while ((pos * 2 <= heap[0] && heap[pos] > heap[pos * 2]) || (pos * 2 + 1 <= heap[0] && heap[pos] > heap[pos * 2 + 1])){
		int next = 0;
		if ((pos * 2 <= heap[0] && heap[pos] > heap[pos * 2]) && (pos * 2 + 1 <= heap[0] && heap[pos] > heap[pos * 2 + 1])){
		    if (heap[pos * 2] > heap[pos * 2 + 1]){
			next = pos * 2 + 1;
		    }else{
			next = pos * 2;
		    }
		}else if (pos * 2 <= heap[0] && heap[pos] > heap[pos * 2]){
		    next = pos * 2;
		}else{
		    next = pos * 2 + 1;
		}
		int temp = heap[next];
		heap[next] = heap[pos];
		heap[pos] = temp;
		pos = next;
	    }
	}
	return root;
    }

    public void add(int value){
	if (heap.length - 1 == heap[0]){
	    resize(heap.length * 2 - 1);
	}
	heap[0]++;
	int pos = heap[0];
	heap[pos] = value;
	if (isMax){
	    while (heap[pos] > heap[pos / 2] && pos / 2 > 0){
		int temp = heap[pos / 2];
		heap[pos / 2] = heap[pos];
		heap[pos] = temp;
		pos /= 2;
	    }
	}else{
	    while (heap[pos] < heap[pos / 2] && pos / 2 > 0){
		int temp = heap[pos / 2];
		heap[pos / 2] = heap[pos];
		heap[pos] = temp;
		pos /= 2;
	    }
	}
    }

    public int peek(){
	if (heap[0] == 0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    public void resize(int newSize){
	int[] newHeap = new int[newSize];
	for (int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];
	}
	heap = newHeap;
    }

    public int size(){
	return heap[0];
    }
}
