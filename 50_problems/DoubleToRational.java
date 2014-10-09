public class DoubleToRational{

	public static void main(String args[]) {
		double a = -0.125;
		System.out.println("Output: " + getRational(a));
	}

	public static String getRational(double a) {
		int ten = 1;
		while(a*ten - (int)(a*ten) != 0)
			ten *= 10;

		int divident = (int)(a * ten);
		int divisor = ten;

		int gcd = 0;
		if(divident > divisor) gcd = getGCD(divident, divisor);
		else gcd = getGCD(divident, divisor);

		divident /= gcd;
		divisor /= gcd;
		
		return "a = " + divident + "/" + divisor;
		
	}

	public static int getGCD(int a, int b) {
		int remainder = a % b;
		if(remainder == 0) return b;
		else return getGCD(b, remainder);
	}
}
