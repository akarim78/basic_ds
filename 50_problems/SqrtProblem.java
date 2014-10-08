public class SqrtProblem {

	public static void main(String args[]) {
		double number = 0.9;
		double result = sqrt(number);
		System.out.println("Sqrt of " + number + " = " + result);
	}

	public static double sqrt(double a) {
		// check for negative
		if(a < 0) return -1;
		// check for 0 and 1
		if(a == 0 || a == 1) return a;
		
		// main
		// define precision
		double precision = 0.0001;
		double start = 0;
		double end = a;
		// 0 < sqrt(a) < a but if a < 1 then 0 < a < sqrt(a)
		if(a < 1) end = 1;

		// loop and precision
		while(end - start > precision) {
			double mid = (start + end)/2;
			double midSqr = mid * mid;
			if(midSqr == a) return mid;
			else if(midSqr < a) start = mid;
			else end = mid;

		}
	
		return (start+end) / 2;
	}
}
