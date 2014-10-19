public class BalancePointArray {

	public static void main(String args[]) {
		int[] input = {1, 2, 9, 4, -1};
		int bindex = getBalancePoint(input);

		System.out.println("Index: " + bindex + "\nValue: " + input[bindex]);
		
		bindex = getBPoint(input);
		System.out.println("Index: " + bindex + "\nValue: " + input[bindex]);
	}

	public static int getBPoint(int[] input) {
		int[] ltr = new int[input.length];
		ltr[0] = input[0];
		for(int i = 1; i < input.length; i++) {
			ltr[i] = ltr[i-1] + input[i];
		}
		
		int[] rtl = new int[input.length];
		rtl[input.length - 1] = input[input.length - 1];
		for(int i = input.length-2; i >= 0; i--) {
			rtl[i] = rtl[i+1] + input[i];
		}

		int bal = 0;
		for(int i = 0; i < input.length; i++){
			if(ltr[i] == rtl[i]) {
				return i;
			}
		}		
		return bal;

	}

	public static int getBalancePoint(int[] input) {
		int sum = 0;
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}

		int leftSum = 0;
		int rightSum = sum-input[0];
		int bal = 0;
		
		for(int i = 1; i < input.length; i++) {
			if(leftSum == rightSum) break;
			bal = i;
			leftSum += input[i - 1];
			rightSum -= input[i];
		}
		return bal;
	}
}
