public class MyDeque<T>{

    public static void main(String[]args){
	MyDeque<Integer> a = new MyDeque<Integer>(false);
	a.addLast(new Integer(1));
	a.addLast(new Integer(2));
	a.addLast(new Integer(3));
	System.out.println(a);
	System.out.println(a.head);
	System.out.println(a.tail);
	System.out.println(a.size);
	System.out.println(a.deque.length);
    }
    
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

    public String toString(){
	String ans = "[ ";
	if (tail > head && size > 0){
	    for (int i = head; i <= tail; i++){
		ans += deque[i] + ",";
	    }
	}else if (size > 0){
	    for (int i = head; i < deque.length; i++){
		ans += deque[i] + ",";
	    }
	    for (int i = 0; i <= tail; i++){
		ans += deque[i] + ",";
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
		resize(size * 2);
		head = 0;
		tail = size;
	    }
	    deque[tail] = value;
	}
	size++;
    }

    public void resize(int newSize){
	Object[] newDeque = new Object[newSize];
	int c = 0;
	if (tail <= head){
	    for (int i = head; i < deque.length; i++){
		newDeque[c] = deque[i];
		c++;
	    }
	    for (int i = 0; i < tail; i++){
		newDeque[c] = deque[i];
		c++;
	    }
	    if (tail != head){
		newDeque[c] = deque[tail];
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
    
