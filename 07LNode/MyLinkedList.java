public class MyLinkedList{
    private LNode head;
    private LNode current;

    public MyLinkedList(){
    }

    public MyLinkedList(int size){
    }

    public String toString(){
	String ans = "[ ";
	LNode temp = head;
	while (temp.getValue() != null){
	    ans += temp.getValue() + ",";
	    current = current.getNext();
	}
	return ans.substring(0, ans.length() - 1) + " ]";
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