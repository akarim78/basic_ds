/*
 * Sorting a stack in ascending order
 *
 */

public class Problem6{

	public static void main(String args[]){
		Stack stack = new Stack();
		stack.push(4);
		stack.push(5);
		stack.push(3);
		stack.push(6);
		
		Stack temp = new Stack();

		// sorting stack using temp
		while(!stack.isEmpty()){
			if(temp.isEmpty()){
				temp.push(stack.pop().data);
			}else{
				int i = temp.peek();
				int k = stack.peek();
				if(k > i){
					Node p = stack.pop();
					int count = 0;
					while(p.data > i){
						stack.push(temp.pop().data);
						i = temp.peek();
						count++;
					}
					temp.push(p.data);
					while(count > 0){
						temp.push(stack.pop().data);
						count--;
					}
					
				} else {
					temp.push(stack.pop().data);
				}

			}
		}

		while(!temp.isEmpty()){
			stack.push(temp.pop().data);
		}

		while(!stack.isEmpty()){
			int x = stack.pop().data;
			System.out.print(x + " ");
		}

	}
}
