import java.util.*;
import java.util.Random;


public class LinkedList {
	
	public static void randInd(List myList) {
	Random rand = new Random();
	for(int i=0;i<myList.size();i++) {
		int  n = rand.nextInt(myList.size()) + 1;//50 is the maximum and the 1 is our minimum
		int z = (int) myList.get(n);
		System.out.println(z);
	  }
	}
	public static void main(String [] args) {
		
		LinkedList l = new LinkedList();
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i=0;i<100;i++) {
			A.add(i);
		}
		//randInd(A);
		//l.addAtBeginning(11);
		//l.addAtBeginning(15);
		//l.addAtEnd(2);
		////l.addAtEnd(1);
		//l.addAtEnd(1);
		//l.addAtEnd(2);
		//l.removeAll();
		//l.size();
		
		
		
	}
	public class Node { //node class to implement linked list needed

		private int data; //define the data of the node
		private Node next; //define the next node connected to this

		
		/**
		 * Take in a data value and nextNode value
		 * @param data, data of the node
		 * @param nextNode, next node connected to this node
		 */
		Node(int data, Node nextNode){
			
			this.data = data;
			this.next = nextNode;
		}
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
		Node(){
			this.data = 0;
			this.next = null;
		}

		/**
		 * Get the data held by this node
		 * @return data, data held by this node
		 */
		public int getData() {
			return data;
		}

		/**
		 * set the data value for this node
		 * 
		 * @param data, data value to be set
		 */
		public void setData(int data) {
			this.data = data;
		}

		/**
		 * get the next node linked to this node
		 * 
		 * @return nextNode, the next node linked to this node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * set the next node connected to this node
		 * @param nextNode the next node to be set to this node
		 */

		public void setNext(Node n) {
			
			this.next = n;
		}
		
		public String toString() {
			
			String returnString = "";
			returnString += data;
			return returnString;
		}
	}

 //-----------------------------------------------------------
	//now for the linked list class implementation which uses node class
	private Node head;
	
	LinkedList(){
		
		Node head = new Node();
	}
	
	public boolean isEmpty() {
		
		if(head == null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void addAtBeginning(int data) {
		//when we add at the front, the new node were adding
		//becomes the head, so i called new node newHead
		Node newHead =  new Node(data);
		if(this.isEmpty()) { //if head == null
			head = newHead;
		} else {
			newHead.next = head; // link the new nodes next to the old head node
			head = newHead; //set head to point to new node wich is now front first node
		}
		
		toStringg();
	}
	
	public void addAtEnd(int data) {
		if(head==null) {
			head = new Node(data);
			System.out.println("items in this linked list:" + data);
			return;
		}
		Node current = head; 
		if(head!=null) {
		while(current.next!=null) {
			current = current.next;//reach the end of the list
			}
		//now that weve reached the end of list, create new node
		current.next = new Node(data);
		toStringg();
	 }
	}
	
	
	public void remove(int data) {
		
		Node current=head;
		while( current.next!=null) {//start at first head node and go thorugh linked list
			if(current.next.data==data) {//iff the next element matches data
				current.next=current.next.next;//set currents next to point to node after the node you want to delete
			}
		}
		toStringg();
		
	}
	
	public void removeAll() {
		
		head=null;

		System.out.println("The list is empty");
	}
	
	
	public void toStringg() {
		Node current = head;
		
		String returnString = "";
		returnString +=  "items in this linked list: ";
		
		while(current.next!=null) {
			returnString += current.data + ", ";
			current = current.next;
		}
		//to remove last comma
		returnString= returnString.substring(0, returnString.length() - 2);
		System.out.println(returnString);
		
		
	}
	
	
	public void size() {
		
		Node current = head;
		int counter = 0;
		while(current.next!=null) {
			current = current.next;
			counter ++;
		}
		System.out.println("the list has " + counter +" elements");
	}
	
	public void get(int index) {
		
	Node current = head;
	int counter=0;
	int result=0;
	while(current.next!=null) {
		 counter++;
		 if(counter==index) {
				result=current.data;
			}
		 current=current.next;	
	  }
	
	System.out.println(result);
  }
}
