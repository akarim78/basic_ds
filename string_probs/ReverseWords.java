/*
 * Reversing order of words in a sentence
 */

import java.util.StringTokenizer;

public class ReverseWords{

	public static void main(String args[]){
		String str = "hello how are you my friend";
		String res = reverse(str);
		System.out.println("Reversed: " + res);
	}

	public static String reverse(String str){
		Stack stack = new Stack();
		StringTokenizer tk = new StringTokenizer(str, " ");
		int count = tk.countTokens();
		while(tk.hasMoreTokens()){
			String temp = tk.nextToken();
			//System.out.println(temp);
			stack.push(temp);
		}

		//System.out.println(""+count);
		String result = "";
		for(int i = 0; i < count; i++){
			result += stack.pop().data+" ";
			//System.out.println(stack.pop().data);
		}

		return result;
		

	} 
}
