import java.util.HashSet;

public class HappyNumbers {

	public static boolean isHappy(int number) {
		HashSet<Integer> cycle = new HashSet<Integer>();
		
		while(number != 1 && cycle.add(number)) {
			int m = 0;
			int digit = 0;
			while(number > 0) {
				digit = number%10;
				m += digit*digit;
				number /= 10;
			}
			number = m;
		}

		return number == 1;

	}

	public static void main(String args[]) {
		System.out.print("Happy Numbers: ");
		for(int i = 0; i <= 100; i++) {
			if(isHappy(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
