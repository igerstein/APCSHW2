import java.util.*;
public class MyHeap{
    public static void main(String[]args){
	MyHeap a = new MyHeap();
	System.out.println(a);
    }

    private int[] heap;
    private boolean isMax;

    public String name(){
	return "gerstein.isaac";
    }

    public MyHeap(){
	heap = new int[2];
	isMax = true;
    }

    public MyHeap(boolean isMax){
	heap = new int[2];
	this.isMax = isMax;
    }

    public String toString(){
	return Arrays.toString(heap);
    }

    public int remove(){
	return 0;
    }

    public void add(int value){
	if (heap.length - 1 == heap[0]){
	    resize(heap.length * 2 - 1);
	}
    }

    public int peek(){
	return 0;
    }

    public void resize(int newSize){
	int[] newHeap = new int[newSize];
	for (int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];
	}
	heap = newHeap;
    }
}