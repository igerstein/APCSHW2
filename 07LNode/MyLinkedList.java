public class MyLinkedList{
    private LNode head;

    public MyLinkedList(){
    }

    public MyLinkedList(int size){
    }

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(1);
	a.add(2);
	a.add(3);
	System.out.println(a);
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
    }

    public int remove(int index){
	return 0;
    }

    public int size(){
	return 0;
    }

    public int indexOf(int value){
	return 0;
    }
}