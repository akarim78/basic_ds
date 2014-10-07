public class ParenthesisProblem {

	public static void main(String args[]) {
		String test = "())";
		boolean problem = false;
		Stack stack = new Stack();
		for(int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			if(c == '(') {
				stack.push(i);
			}else if(c == ')') {
				if(stack.isEmpty()) {
					problem = true;
					System.out.println("Problem with " + i + " position");
					break;
				} else {
					stack.pop();
				}
			}

		}

		if(stack.isEmpty() && problem == false) {
			System.out.println("Parenthesis balanced");
		} else if(!stack.isEmpty()){
			Node n = stack.pop();
			System.out.println("Problem with " + n.data + " position");	
		}

	}
}
