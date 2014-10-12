public class Division {

	public static void main(String args[]) {
		int x = 10000;
		int y = 2;

		System.out.println("Div: " + naiveDiv(x, y));
		System.out.println("Div: " + div(x, y));
	}

	public static int naiveDiv(int a, int b) { 
		if(a < b){
			System.out.println("Dividend: " + (a-b));
			return 0;
		}
		int loopTime = 0;
		int count = 0;
		while(a >= b) {
			loopTime++;
			a-=b;
			count ++;
		}
		System.out.println("Loop time: " + loopTime);
		System.out.println("Dividend: " + a);
		return count;

	}

	public static int div(int dividend, int divisor) {
		int quotient = 0;
		int loopTime = 0;
		int currentDivisor = divisor;
		int currentQuotientBase = 1;

		while(dividend >= divisor) {
			loopTime++;
			if(dividend >= currentDivisor){
				dividend -= currentDivisor;
				quotient += currentQuotientBase;
				currentDivisor *= 2;                                                                    
                                currentQuotientBase *= 2;
			} else{
				currentDivisor /= 2;
				currentQuotientBase /= 2;
			}
		}
		System.out.println("Loop time: " + loopTime);                                                             
                System.out.println("Dividend: " + dividend);
                return quotient;
	}
}
