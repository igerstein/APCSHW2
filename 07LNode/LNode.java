public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(T value){
	setValue(value);
    }

    public T getValue(){
	return value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setValue(T value){
	this.value = value;
    }

    public void setNext(LNode<T> next){
	this.next = next;
    }

    public String toString(){
	return "" + value;
    }
}
    
