import java.util.*;
public class MyStack<T>{

    public String name(){
	return "gerstein.isaac";
    }

    private MyLinkedList<T> stack = new MyLinkedList<T>();

    public T push(T item){
	stack.add(item);
	return item;
    }

    public T pop(){
	if (stack.size() == 0){
	    throw new EmptyStackException();
	}
	return stack.remove(stack.size() - 1);
    }

    public T peek(){
	if (stack.size() == 0){
	    throw new EmptyStackException();
	}
	return stack.get(stack.size() - 1);
    }

    public boolean empty(){
	return stack.size() == 0;
    }
}
    
    
