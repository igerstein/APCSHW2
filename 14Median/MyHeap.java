import java.util.*;
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
	return Arrays.toString(heap);
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
		if (heap[pos] < heap[pos * 2]){
		    int temp = heap[pos * 2];
		    heap[pos * 2] = heap[pos];
		    heap[pos] = temp;
		    pos *= 2;
		}else{
		    int temp = heap[pos * 2 + 1];
		    heap[pos * 2 + 1] = heap[pos];
		    heap[pos] = temp;
		    pos = pos * 2 + 1;
		}
	    }
	}else{
	    while ((pos * 2 <= heap[0] && heap[pos] > heap[pos * 2]) || (pos * 2 + 1 <= heap[0] && heap[pos] > heap[pos * 2 + 1])){
		if (heap[pos] > heap[pos * 2]){
		    int temp = heap[pos * 2];
		    heap[pos * 2] = heap[pos];
		    heap[pos] = temp;
		    pos *= 2;
		}else{
		    int temp = heap[pos * 2 + 1];
		    heap[pos * 2 + 1] = heap[pos];
		    heap[pos] = temp;
		    pos = pos * 2 + 1;
		}
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
