/*
 * finding rank
 */

public class Problem8{
	private static RankNode root = null;

	public static void track(int number) {
		if(root == null) {
			root = new RankNode(number);
		} else{
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}

	public static void main(String args[]){
		track(5);
		track(1);
 		track(4); 
		track(4);
		track(5); 
		track(9); 
		track(7); 
		track(13);
		track(3);
		System.out.println("Rank: " + getRankOfNumber(1));
		System.out.println("Rank: " + getRankOfNumber(3)); 
		System.out.println("Rank: " + getRankOfNumber(4));  
	}
}

