public class MyLinkedList<T>{
    private LNode<T> head;
    private LNode<T> tail;
    private int size = 0;

    public String name(){
	return "gerstein.isaac";
    }

    public String toString(){
	String ans = "[ ";
	LNode<T> temp = head;
	while (temp != null){
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	}
	return ans.substring(0, ans.length() - 1) + " ]";
    }

    public T get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size() - 1){
	    return tail.getValue();
	}else{
	    LNode<T> temp = head;
	    for (int i = 0; i < index; i++){
		temp = temp.getNext();
	    }
	    return temp.getValue();
	}
    }

    public T set(int index, T value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size() - 1){
	    T previous = tail.getValue();
	    tail.setValue(value);
	    return previous;
	}else{
	    LNode<T> temp = head;
	    for (int i = 0; i < index; i++){
		temp = temp.getNext();
	    }
	    T previous = temp.getValue();
	    temp.setValue(value);
	    return previous;
	}
    }

    public boolean add(T value){
	if (head == null){
	    head = new LNode<T>(value);
	}else if (tail == null){
	    tail = new LNode<T>(value);
	    head.setNext(tail);
	}else{
	    LNode<T> newNode = new LNode<T>(value);
	    tail.setNext(newNode);
	    tail = newNode;
	}
	size++;
	return true;
    }

    public void add(int index, T value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size()){
	    add(value);
	}else if (index == 0){
	    LNode<T> newNode = new LNode<T>(value);
	    newNode.setNext(head);
	    head = newNode;
	    size++;
	}else{
	    LNode<T> temp = head;
	    for (int i = 0; i < index - 1; i++){
		temp = temp.getNext();
	    }
	    LNode<T> newNode = new LNode<T>(value);
	    LNode<T> nodeAfter = temp.getNext();
	    temp.setNext(newNode);
	    newNode.setNext(nodeAfter);
	    size++;
	}
    }

    public T remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	size--;
	if (index == 0){
	    T previous = head.getValue();
	    head = head.getNext();
	    return previous;
	}else{
	    LNode<T> temp = head;
	    for (int i = 0; i < index - 1; i++){
		temp = temp.getNext();
	    }
	    T previous = temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	    if (index == size()){
		tail = temp;
	    }
	    return previous;
	}
    }

    public int size(){
	return size;
    }

    public int indexOf(T value){
	int index = 0;
	LNode<T> temp = head;
	while (temp != null){
	    if (temp.getValue() == value){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }
}
