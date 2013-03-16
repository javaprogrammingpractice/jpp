package leetcode.ch;

public class PowXN {
	
	public double pow(double x, int n) {
		
		if (n == Integer.MIN_VALUE) {
			return pow(x*x, n /2);
		} else if (n < 0) {
			return 1 / pow(x, - 1 * n);
		} else if (n==0) {
			return 1;
		} else if (n==1) {
			return x;
		} else if (n==2) {
			return x * x;
		} else if ((n%2) == 0) {
			return pow(x*x, n/2);
		} else {
			return x * pow(x*x, (n-1)/2);
		}
    }
	
	public static void main(String[] args) {
		
		PowXN pow = new PowXN();
		System.out.println(pow.pow(1.00000, -2147483648));
	}
	

}
