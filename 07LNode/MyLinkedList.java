public class MyLinkedList{
    private LNode head;
    private LNode tail;
    private int size = 0;

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();;
	a.add(1);
	a.add(2);
	a.add(3);
	System.out.println(a.get(1));
    }

    public String toString(){
	String ans = "[ ";
	LNode temp = head;
	while (temp != null){
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	}
	return ans.substring(0, ans.length() - 1) + " ]";
    }

    public int get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size() - 1){
	    return tail.getValue();
	}else{
	    LNode temp = head;
	    for (int i = 0; i < index; i++){
		temp = temp.getNext();
	    }
	    return temp.getValue();
	}
    }

    public void set(int index, int value){
    }

    public boolean add(int value){
	if (head == null){
	    head = new LNode();
	    head.setValue(value);
	}else if (tail == null){
	    tail = new LNode();
	    tail.setValue(value);
	    head.setNext(tail);
	}else{
	    LNode newNode = new LNode();
	    newNode.setValue(value);
	    tail.setNext(newNode);
	    tail = newNode;
	}
	size++;
	return true;
    }

    public void add(int index, int value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index == size()){
	    add(value);
	}else if (index == 0){
	    LNode newNode = new LNode();
	    newNode.setValue(value);
	    newNode.setNext(head);
	    head = newNode;
	    size++;
	}else{
	    LNode temp = head;
	    for (int i = 0; i < index - 1; i++){
		temp = temp.getNext();
	    }
	    LNode newNode = new LNode();
	    LNode nodeAfter = temp.getNext();
	    newNode.setValue(value);
	    temp.setNext(newNode);
	    newNode.setNext(nodeAfter);
	    size++;
	}
    }

    public int remove(int index){
	return 0;
    }

    public int size(){
	return size;
    }

    public int indexOf(int value){
	return 0;
    }
}
