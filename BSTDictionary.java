package src;

/**
 * Sysc 2100 Assignment 4
 * @author (Gabriele Sarwar)
 * 
 * @version (March 19 2018)
 */
public  class BSTDictionary<E,K extends Sortable> implements Dictionary<E,K>
{
    BSTNode<E,K> root; // The root of the BST Dictionary
    
    public BSTDictionary()// Constructors
    {
        this(null);
    }

    public BSTDictionary(BSTNode<E,K> root)
    {
       this.root = root;
    }
    
    public Object search(Sortable key) {
		BSTNode<E, K> currentNode = root;
		boolean always = true;
		for(;always;) {
			if(currentNode == null) {
				break;
			}
			else if(key.compareTo(currentNode.getKey()) == 0) {
				//base case, when key youre looking for is same as current nodes key
				return currentNode.getElement(); //you have found ur node
			}
			else if(key.compareTo(currentNode.getKey()) < 0) {
				//if your key youre looking for is less then the current nodes key, go to te left
				currentNode = currentNode.getLeft(); 
			}
			//otherwise move to the right
			else if(key.compareTo(currentNode.getKey()) > 0) {
				currentNode = currentNode.getRight();
			}
		} return null;
	}

	// delete an entry with key KEY
    
    
   
    //delete node method
    public void delete(Sortable key) {
    	//set u 2 pointers
		BSTNode<E, K> currentNode = root;
		BSTNode<E, K> previousNode = root;
		if(root == null) {
			
		}
		if(key.compareTo(root.getKey()) == 0) {//if it equals the string
			currentNode = currentNode.getLeft();
			BSTNode<E, K> previousNode2 = root;
			for(boolean ever = true; ever;) {
				if(currentNode == null) {
					if(!previousNode.equals(root)) {
						previousNode2.setRight(null);
					}
					previousNode.setLeft(root.getLeft());
					previousNode.setRight(root.getRight());
					root = previousNode;
					break;
				} else {
					previousNode2 = previousNode; 
					previousNode = currentNode;
					currentNode = currentNode.getRight();
				}
			}
		}
		else {
			for(boolean a = true; a;) {
				if(currentNode == null) {
					return;
				} else if(key.compareTo(currentNode.getKey()) == 0) {
					break;
				
				} else if(key.compareTo(currentNode.getKey()) > 0) {
					previousNode = currentNode;
					currentNode = currentNode.getRight();
				}
				else if(key.compareTo(currentNode.getKey()) < 0) {
					previousNode = currentNode;
					currentNode = currentNode.getLeft();
				}
			}
			//if the string is greater then this.key
			if(key.compareTo(previousNode.getKey()) < 0) {
				previousNode.setLeft(currentNode.getLeft());
			}  else if(key.compareTo(previousNode.getKey()) > 0) {
				previousNode.setRight(currentNode.getRight());
			}
		}	
	}

	
	
	// insert a key-value pair into the dictionary
	public void insert(K key, E element) // inserts a key value pair into the tree
	{
		
		if(root == null) 
		{
			root = new BSTNode<E, K>(key, element, null, null); //when its empty, insert is ez
		}
		
		else 
		{
			insertWhenNotEmpty(root, key, element); //make use of insertWhenNotEmpty
		}
	}
	//to insert when you have to go through a tree that isnt empty
	public void insertWhenNotEmpty(BSTNode<E, K> node, K key, E element) { // inserts a node below a specific node
		
		if(key.compareTo(node.getKey()) == 0) //if they equal
		{
			//skip
		}
		//if node key less then key
		else if(key.compareTo(node.getKey()) > 0) 
		{
			
			//if right is null
			if(node.getRight() == null) 
			{ //create a new right node
				node.setRight(new BSTNode<E, K>(key, element, null, null));
			}
			else 
			{//greater side goes to the right
				insertWhenNotEmpty(node.getRight(), key, element);
			}
		}
		
		else if(key.compareTo(node.getKey()) < 0) 
		{
			
			if(node.getLeft() == null) 
			{
				node.setLeft(new BSTNode<E, K>(key, element, null, null));
			}
			else insertWhenNotEmpty(node.getLeft(), key, element);
		}
		
		
	}
	
	// return the depth of the underlying tree
	public int depth() {

		if(root == null) {
			return 0; //empty tree
		} else {
			return getDepth(root);
		}
	}
	
	 //find depth of a bst
	 // @param starts with root node
	  //@return the max depth of a BST
	 
	public int getDepth(BSTNode<E,K> node) {
		
		if(node == null) {
			return 0; // an empty tree 
		} else {
			int leftDepth = getDepth(node.left);
			int rightDepth = getDepth(node.right);
			//whichever is the larger subtree
			if(leftDepth > rightDepth) {
				return (leftDepth + 1); //depth is +1
			} else {
				return (rightDepth + 1);
			}
		}
		
	}
	
	//prints nodes in tree using recursion printNode method
	public void printTree() {
		printNode(root); // call printNode method
		System.out.print("\n");
		
	}
	

	  //print out in inorder order
	 // @param the initial starting 
	 
	public void printNode(BSTNode<E, K> node) {
		if(node == null) { //if its null u dont print
			return;
		} if(node.getLeft() != null) {
			printNode(node.getLeft()); //recurse
		} System.out.print(node.getElement() + " ");
		if(node.getRight() != null) {
			printNode(node.getRight());
		}
	}
	
}
