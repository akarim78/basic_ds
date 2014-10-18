public class GuessingPassRate{

	public static void main(String args[]) {
		System.out.println("Pass Rate: " + passRate(10, 5));
	}

	public static double passRate(int N, int k) {
		double singleCorrect = 0.25;
		double singleWrong = 0.75;

		double[][] table = new double[N+1][k+1];

		table[1][1] = singleCorrect;
		table[1][0] = singleWrong;

		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= k; j++) {
				if(j == 0)
					table[i][j] = table[i-1][j] * singleWrong;
				else
					table[i][j] = table[i-1][j-1] * singleCorrect + table[i-1][j]*singleWrong;
			}
		}

		return table[N][k];
		
	}
}
