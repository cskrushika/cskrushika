/**
 * Program to reverse a stack in place using recursion
 * 
 * - Double recursion here.
 * - Here only the ADT of the stack, push(), pop(), isEmpty() are used.
 * 
 * */

package puzzleimpl;

import java.util.Stack;

public class ReverseStackInPlaceADT {
	/* Pops an element and pushes it to bottom*/
	public static void reverse(Stack<String> stack){
		if(stack.isEmpty())
			return;
		String element = stack.pop();
		reverse(stack);		
		pushToBottomOfStack(stack, element);
	}
	
	/*Does and in-place shuffle */
	private static void pushToBottomOfStack(Stack<String> stack, String data){
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}
		String element = stack.pop();
		pushToBottomOfStack(stack, data);
		stack.push(element);
	}

	public static void main(String args[]){
		Stack<String> stack= new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println("Initial stack: "+stack);
		ReverseStackInPlace.reverse(stack);
		System.out.println("After reversal: "+stack);
	}
}
