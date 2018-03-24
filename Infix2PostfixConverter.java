package idk;

public class Infix2PostfixConverter {

	public static void main (String[] args ) {
		
		String l = "3 * ( 17 - (5+2))/(2+3)";
		convertPostfix(l);
	
	}
	
	//Determines if element in expression is an operand 
	private static boolean isOperand(char c) {
		
		if(c <= '9' && c >= '0' ) return true;
		return false;
	} 
	

	//determines the precedence of an operator (Bedmas)
	//higher weight means higher precedence
	private static int OperatorPrecedence(char op) {
		
		int weight = -1;
		
		if (op == '+' || op == '-') { //
			weight = 1;
		}
		if (op == '*' || op == '/' ) {
			weight = 2;
		}
		return weight;
	}
	
	//Determines if element in expression is an operator, retrurns true if yes 
	private static boolean isOperator(char c) {
		
		if (c == '-' || c == '/' || c == '*' ||  c == '+') return true;
		
		return false;
	}
	
	//returnns true if precedence are same, otherwise respects precedence bedmas rules
	private static boolean greatestPrecedence(char op1, char op2) {
		
		int weight1= OperatorPrecedence(op1);
		int weight2 = OperatorPrecedence(op2);
		
		if (weight1 == weight2) {
			return true;
		}

		return weight1 > weight2 ? true: false;
		
	}
	
	//converts given infix expression to postfix
	public static void  convertPostfix(String expression) {
		
		String FinalpostFix = " "; // our final result 
		
		ReferenceBasedStack<Character> Operands = new ReferenceBasedStack<Character>(); //character stack for operators
		//created a stack which will contain operands only
		for(int i = 0; i < expression.length(); i++) {//scan
			char c=expression.charAt(i);
			
			if(c== ' ' || expression.charAt(i)== ',') continue; //ignore delimiters
			
			//if what were looking at is an operand just add it to final post fix expression
			if (isOperand(c)) {
				FinalpostFix += c;
					// for expressions with multiple terms, add space if the next character is not operator
					if(i + 1 >= expression.length() || !isOperand(expression.charAt(i + 1))) {
						FinalpostFix += ' ';
				}	
				
			} else if (isOperator(c)) { //if its an operator
				//while stack is not empty and its not a bracket & doesnt have higher precedence then whatever
				//is at the top of the stack currently
				
				while(!Operands.isEmpty() && Operands.top() != '(' && greatestPrecedence(Operands.top(),c)) {
					//take what is in stack and append to final postfix result
					FinalpostFix += Operands.top(); //doesnt change the stack
					Operands.pop();	//this does get rid of it from the stack
				}
				//otherwise, if its an operator with higher precedence then whats in the stack right now, push
				Operands.push(c);
					
			} else if (expression.charAt(i) == '(') {
				
				Operands.push(c);
				
			} else if (c == ')') {
				//keep on popping until closing brace
				while(!Operands.isEmpty() && Operands.top() != '(') {
					FinalpostFix += Operands.top();
					Operands.pop();
				}
				Operands.pop();
			}	
			
		}
		
		while(!Operands.isEmpty()) {
			FinalpostFix += Operands.top();
			Operands.pop();
		}
		
		System.out.println("Infix expression: " + expression.toString());
		System.out.println("Postfix expression: " + FinalpostFix.toString());
		System.out.println("Postfix Evaluated is: " + getPostfixValue(FinalpostFix));
		
	
		
		
	}
	
	public static Double getPostfixValue(String postfixExpression) {
		
		ReferenceBasedStack<Double> StackOfOperands = new ReferenceBasedStack<Double>();
		char[] digits = postfixExpression.toCharArray();
		
		for(int i = 0; i < digits.length;i++) {
			char p = digits[i];
			// Scanning each term from left. 
			if(p == ' ' ||p == ',') continue; // If character is a delimitter, move on. 

			if(isOperator(p)) {// If term is operator, perform operation and push the result back. 
				
                switch (p) {
                case '*': StackOfOperands.push(StackOfOperands.pop() * StackOfOperands.pop());     break;
                case '-': StackOfOperands.push(-StackOfOperands.pop() + StackOfOperands.pop());    break;
                case '+': StackOfOperands.push(StackOfOperands.pop() + StackOfOperands.pop());     break;
                case '/': StackOfOperands.push(1 / StackOfOperands.pop() * StackOfOperands.pop()); break;
            } 				
			} else if (isOperand(p)) {
            	
				StackOfOperands.push(0.0);
				//For a number with more than one digits
				// Every time , we get a digit towards right, we can multiply operand by 10 
				// and push it to stack. 
                while (i<postfixExpression.length() && Character.isDigit(digits[i]))
                	StackOfOperands.push(10.0 * StackOfOperands.pop() + (digits[i++] - '0'));
            }
			
		}
		// Stack will finally have one element, the output
			return StackOfOperands.top();
		
	}
	
	
	
	
}