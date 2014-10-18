import java.util.Stack;

public class LargestRectInHist {

	public static void main(String args[]) {
		int[] hist = {2, 4, 2, 1};
		System.out.println("Size: " + largestRect(hist));
	}

	public static int largestRect(int[] hist) {
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indices = new Stack<Integer>();

		// return value
		int largestSize = 0;

		for(int i = 0; i < hist.length; i++) {
			if(heights.isEmpty() || hist[i] > heights.peek()) {
				heights.push(hist[i]);
				indices.push(i);

			} else if(hist[i] < heights.peek()) {
				int lastIndex = 0;
				while(!heights.isEmpty() && hist[i] < heights.peek()) {
					int height = heights.pop();
					lastIndex = indices.pop();
					int rect = height * (i - lastIndex);
					if(largestSize < rect)
						largestSize = rect;
				}
				System.out.println(hist[i] + "--" + lastIndex);
				heights.push(hist[i]);
				indices.push(lastIndex);

			} else if(hist[i] == heights.peek()) {
				
			}
		}

		while(!heights.isEmpty()){
			int rect = heights.pop() * (hist.length-indices.pop());
			if(largestSize < rect)
				largestSize = rect;
		}

		return largestSize;

	}
}
