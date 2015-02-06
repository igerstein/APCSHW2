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
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	} else if (n == 0){
	    return 0.0;
	} else {
	    return sqrtHelper(n, 1.0);
	}
    }
    public double sqrtHelper(double n, double guess){
	double newGuess = (n / guess + guess) / 2;
	if ((guess >= newGuess && guess / newGuess < 1.001) || (newGuess > guess && newGuess / guess < 1.001)){
	    return newGuess;
	} else {
	    return sqrtHelper(n, newGuess);
	}
    }
}
