import java.util.*;
public class MyQueue<T>{

    public String name(){
	return "gerstein.isaac";
    }

    private MyLinkedList<T> queue = new MyLinkedList<T>();

    public boolean enqueue(T item){
	queue.add(item);
	return true;
    }

    public T dequeue(){
	if (queue.size() == 0){
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }
}
