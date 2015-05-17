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
	if ((smaller.size() == 0 && larger.size() == 0) || value < getMedian()){
	    smaller.add(value);
	}else{
	    larger.add(value);
	}
	if (smaller.size() > larger.size() + 1){
	    larger.add(smaller.remove());
	}else if (larger.size() > smaller.size() + 1){
	    smaller.add(larger.remove());
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
