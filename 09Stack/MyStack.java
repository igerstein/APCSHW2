import java.util.*;
public class MyStack<T>{

    public String name(){
	return "gerstein.isaac";
    }
    
    public class StackSection<T>{
	private T value;
	private StackSection<T> previous;

	public StackSection(T value){
	    setValue(value);
	}

	public T getValue(){
	    return value;
	}

	public StackSection<T> getPrevious(){
	    return previous;
	}

	public void setValue(T value){
	    this.value = value;
	}

	public void setPrevious(StackSection<T> previous){
	    this.previous = previous;
	}
    }

    private StackSection<T> top;

    public T push(T item){
	if (top == null){
	    top = new StackSection<T>(item);
	}else{
	    StackSection<T> last = new StackSection<T>(top.getValue());
	    last.setPrevious(top.getPrevious());
	    top.setValue(item);
	    top.setPrevious(last);
	}
	return item;
    }

    public T pop(){
	if (top == null){
	    throw new EmptyStackException();
	}
	T item = top.getValue();
	top = top.getPrevious();
	return item;
    }

    public T peek(){
	if (top == null){
	    throw new EmptyStackException();
	}
	return top.getValue();
    }

    public boolean empty(){
	return top == null;
    }
}
    
    
