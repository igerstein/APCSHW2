import java.util.*;
public class MyDeque<T>{
    
    public String name(){
	return "gerstein.isaac";
    }

    private Object[] deque;
    private int head;
    private int tail;
    private int size;
    private boolean shrink;

    public MyDeque(boolean shrink){
	deque = new Object[0];
	size = 0;
	this.shrink = shrink;
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
	String ans = "[ ";
	if (size > 0){
	    if (tail > head){
		for (int i = head; i <= tail; i++){
		    ans += deque[i] + ",";
		}
	    }else if (tail < head){
		for (int i = head; i < deque.length; i++){
		    ans += deque[i] + ",";
		}
		for (int i = 0; i <= tail; i++){
		    ans += deque[i] + ",";
		}
	    }else{
		ans += deque[head] + ",";
	    }
	}
	return ans.substring(0, ans.length() - 1) + " ]";
    }
    
    public void addLast(T value){
	if (size == 0){
	    deque = new Object[1];
	    deque[0] = value;
	    head = 0;
	    tail = 0;
	}else{
	    tail++;
	    if (tail == deque.length){
		tail = 0;
	    }
	    if (head == tail){
		tail--;
		if (tail == -1){
		    tail = deque.length - 1;
		}
		resize(size * 2);
		head = 0;
		tail = size;
	    }
	    deque[tail] = value;
	}
	size++;
    }

    public void addFirst(T value){
	if (size == 0){
	    deque = new Object[1];
	    deque[0] = value;
	    head = 0;
	    tail = 0;
	}else{
	    head--;
	    if (head == -1){
		head = deque.length - 1;
	    }
	    if (head == tail){
		head++;
		if (head == deque.length){
		    head = 0;
		}
		resize(size * 2);
		head = deque.length - 1;
		tail = size - 1;
	    }
	    deque[head] = value;
	}
	size++;
    }
  
    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T element = (T)deque[tail];
	tail--;
	if (tail == -1){
	    tail = deque.length - 1;
	}
	size--;
	if (size <= deque.length / 4 && shrink){
	    if (size == 0){
		deque = new Object[0];
	    }else{
		resize(deque.length / 2);
		head = 0;
		tail = size - 1;
	    }
	}
	return element;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T element = (T)deque[head];
	head++;
	if (head == deque.length){
	    head = 0;
	}
	size--;
	if (size <= deque.length / 4 && shrink){
	    if (size == 0){
		deque = new Object[0];
	    }else{
		resize(deque.length / 2);
		head = 0;
		tail = size - 1;
	    }
	}
	return element;
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deque[tail];
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deque[head];
    }

    public void resize(int newSize){
	Object[] newDeque = new Object[newSize];
	int c = 0;
	if (tail < head){
	    for (int i = head; i < deque.length; i++){
		newDeque[c] = deque[i];
		c++;
	    }
	    for (int i = 0; i <= tail; i++){
		newDeque[c] = deque[i];
		c++;
	    }
	}else{
	    for (int i = head; i <= tail; i++){
		newDeque[c] = deque[i];
		c++;
	    }
	}
	deque = newDeque;
    }
}
    
