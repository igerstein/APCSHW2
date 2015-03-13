public class MyLinkedList{
    private LNode head;

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(1, 9);
	System.out.println(a);
	System.out.println(a.size());
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
	return 0;
    }

    public void set(int index, int value){
    }

    public boolean add(int value){
	if (head == null){
	    head = new LNode();
	    head.setValue(value);
	}else{
	    LNode temp = head;
	    while (temp.getNext() != null){
		temp = temp.getNext();
	    }
	    LNode nextNode = new LNode();
	    nextNode.setValue(value);
	    temp.setNext(nextNode);
	}
	return true;
    }

    public void add(int index, int value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (head == null){
	    head = new LNode();
	    head.setValue(value);
	}else{
	    if (index == 0){
		LNode newNode = new LNode();
		newNode.setValue(value);
		newNode.setNext(head);
		head = newNode;
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
	    }
	}
    }

    public int remove(int index){
	return 0;
    }

    public int size(){
	int size = 0;
	LNode temp = head;
	while (temp != null){
	    size++;
	    temp = temp.getNext();
	}
	return size;
    }

    public int indexOf(int value){
	return 0;
    }
}