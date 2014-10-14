public class PrintSpiral {

	public static void main(String args[]) {
		int[][] num = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}};//, {10, 9, 8, 7}};
		printSpiral(num);
		System.out.println();
	}

	public static void printSpiral(int[][] num) {
		int rows = num.length;
		int columns = num[0].length;
		System.out.println("Matrix dim: " + rows + " X " +columns);

		int x = 0; // column
		int y = -1; // row indices
		int index = 0;

		while(true) {
			int pLen = 0;
			if(index % 2 == 0)
				pLen = columns - (index/2);
			else
				pLen = rows - (index/2) -1;
			//System.out.println("PLen: " + pLen);
			if(pLen == 0) break;

			// direction
			int xIncr = 0;
			int yIncr = 0;
			switch(index%4){
				case 0: yIncr = 1; break; // right
				case 1: xIncr = 1; break; // down
				case 2: yIncr = -1; break; // left
				case 3: xIncr = -1; break; // up
			}

			for(int i = 0; i< pLen; i++) {
				System.out.print(num[x + (i+1) * xIncr][y + (i+1) * yIncr]+" ");
			}
			x = x+ pLen*xIncr;
			y = y+ pLen*yIncr;

			index++;
		}

	}
}
