public class ParenthesisPrint {

	public static void main(String args[]){
		printParenthesis(5, 5, "");
		return;
	}

	// define method header
	// left and right 
	public static void printParenthesis(int leftRemain, int rightRemain, String currentString) {
		// check if need to go further
		if(rightRemain == 0) {
			System.out.println(currentString);
			return;
		}
		// recursive
		if(leftRemain > 0){ // more left left for printing
			// choice 1: print another (
			printParenthesis(leftRemain - 1, rightRemain, currentString+"(");
			// more left used
			if(leftRemain < rightRemain) {
				printParenthesis(leftRemain, rightRemain - 1 , currentString+")");
			}
		} else { // only right left
			printParenthesis(leftRemain, rightRemain - 1, currentString + ")");	
		}
		
		
	}
}
