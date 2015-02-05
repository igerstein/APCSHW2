public class Recursion{
    public String name(){
	return "Gerstein,Isaac";
    }
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	} else if (n < 2){
	    return 1;
	} else {
	    return n * fact(n - 1);
	}
    }
}
