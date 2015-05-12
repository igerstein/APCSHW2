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
	heap = new int[1];
	isMax = true;
    }

    public MyHeap(boolean isMax){
	heap = new int[1];
	this.isMax = isMax;
    }

    public String toString(){
	return Arrays.toString(heap);
    }

    public int remove(){
	return 0;
    }

    public void add(int value){
    }

    public int peek(){
	return 0;
    }
}