/**
 * Program to reverse a stack in place using recursion
 * 
 * - Double recursion here.
 * - Here the stack.length() is used and the TRACE is accordingly. 
 * 		For pure ADT version {@see ReverseStackInPlaceADT}. 
 * 
 * TRACE: 
 * reverse([ABCD])							// [A,B,C,D]
	pop D	reverse([ABC])					// [A,B,C]
		pop C	reverse([AB])				// [A,B]
			pop B							// [A]
			stack.size==1
			pushToBottomOfStack([A],B)
			element = pop() = A 			// []
			stack.size=0
				stack.push(data)			// [B]
			stack.push(element)				// [B,A]
		pushToBottomOfStack([B,A],C)
			element = pop() = A 			// [B]
			stack.size!=0
			pushToBottomOfStack([B],C)
				element = pop() = B 		// []
				stack.size=0
					stack.push(data)		// [C]
				stack.push(element)			// [C,B]
			stack.push(element)				// [C,B,A]
	pushToBottomOfStack([C,B,A],D)
		element = pop() = A 				// [C,B]
		stack.size!=0
		pushToBottomOfStack([C,B],D)
			element = pop() = B 			// [C]
			stack.size!=0
			pushToBottomOfStack([C],D)
				element = pop() = C 		// []
				stack.size==0
					stack.push(data)		//[D]
				stack.push(element)			//[D,C]
			stack.push(element)				//[D,C,B]
		stack.push(element)					//[D,C,B,A]		// final stack.
	end push
end reverse
 * */

package puzzleimpl;

import java.util.Stack;

public class ReverseStackInPlace {
	/* Pops an element and pushes it to bottom*/
	public static void reverse(Stack<String> stack){
		String element = stack.pop();
		if(stack.size()!=1)
			reverse(stack);		
		pushToBottomOfStack(stack, element);
	}
	
	/*Does and in-place shuffle */
	private static void pushToBottomOfStack(Stack<String> stack, String data){
		String element = stack.pop();
		if(stack.isEmpty())
			stack.push(data);
		else 
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
