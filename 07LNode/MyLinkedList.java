public class MyLinkedList{
    private LNode head;
    private LNode current;

    public MyLinkedList(){
    }

    public MyLinkedList(int size){
    }

    public String toString(){
	String ans = "";
	current = head;
	while (current.getValue() != null){
	    ans += current.getValue();
	    if (current.getNext() != null){
		ans += ", ";
	    }
	    current = current.getNext();
	}
	return ans;
    }

    public int get(int index){
    }

    public void set(int index, int value){
    }

    public void add(int value){
	//First set head, then set at the end
    }

    public void add(int index, int value){
    }

    public int remove(int index){
    }

    public int size(){
    }

    public int indexOf(int value){
    }
}