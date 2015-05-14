public class RunningMedian{
    private MyHeap smaller, larger;

    public RunningMedian(){
	smaller = new MyHeap();
	larger = new MyHeap(false);
    }

    public String name(){
	return "gerstein.isaac";
    }

    public void add(int value){
	if (value < getMedian()){
	    smaller.add(value);
	}else{
	    larger.add(value);
	}
    }

    public double getMedian(){
	if (smaller.size() > larger.size()){
	    return (double)smaller.peek();
	}else if (larger.size() > smaller.size()){
	    return (double)larger.peek();
	}else{
	    return (smaller.peek() + larger.peek()) / 2.0;
	}
    }
}