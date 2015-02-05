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
    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	} else if (n == 0){
	    return 0;
	} else if (n == 1){
	    return 1;
	} else {
	    return fibHelper(n, 0, 1);
	}
    }
    public int fibHelper(int n, int a, int b){
	if (n == 0){
	    return a;
	} else {
	    return fibHelper(n - 1, b, a + b);
	}
    }
}
