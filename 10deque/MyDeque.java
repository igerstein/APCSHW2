public class MyDeque<T>{

    public String name(){
	return "gerstein.isaac";
    }

    private Object[] deque;
    private int head;
    private int tail;

    public void addLast(T value){
	if (deque.length == 0){
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
		tail = deque.length;
		resize(deque);
	    }
	    deque[tail] = value;
	}
    }

    public void resize(Object[] deque){
    }
}
    