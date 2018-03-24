package idk;

public class ReferenceBasedStack<T> {
	
	private T items;
	private Node top;
	
	public static void main (String[] args ) {
		
		ReferenceBasedStack s = new ReferenceBasedStack();
		s.push('c');
		//s.push(0);
		s.peek();
	
	} 
	
	ReferenceBasedStack(){ //constructor to initialize
		items = null;
		top = null;
	}
	
	//returns top of stack
	public T top() {
		return (T) top.seeData(); //simply return whats at the top of stack
	}
	//pushes element to stack
	public void push(T data) {
		top = new Node(data,top); //assign top to the new element
	}
	
	//looks at whats the top 
	public T peek() {
		if(top == null) {
			System.out.println("empty");
			
		} else {
			System.out.println((T) top.seeData());
		}
		return  (T) top.seeData();
	}
	//pops element from stack
	public T pop() {
		
		if(top == null) {
			System.out.println("empty");
			return null;
		} else {
			T topElement = (T) top.seeData(); //to return what was at top
			top =  top.seePrevious(); //set top to element under top
			return topElement;
		}
	}
	
	//pops all elements
	public void popAll() {
	
		if(top == null) {
			System.out.println("empty");
			
		} else {
			while(top!=null) { //keep popping till top == null
			T topElement = (T) top.seeData();
			top =  top.seePrevious();
			
		}
	   }
	}
	//returns true if stacks empty
	public boolean isEmpty() {
		return (top == null) ; //if top is null its empty
		
	}
}


