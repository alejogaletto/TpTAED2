package Arbol;

public class BynaryTree {
	private static Node root;
	
	private Node addRecursive(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if(value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		return current;
	}
	
	public void add(int value) {
		setRoot(addRecursive(getRoot(), value));
	}
	
	public static BynaryTree createBynaryTree() {
		BynaryTree bt = new BynaryTree();
		
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);

	    return bt;
	}
	
	public static boolean containsNodeRecursive(Node current, int value) {
		if(current == null) {
			return false;
		}if(value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value) :  containsNodeRecursive(current.right, value);  
	}
	
	public static boolean containsNode(int value) {
		return containsNodeRecursive(getRoot(), value);
	}
	
	private static Node deleteRecursive(Node current, int value) {
		if(containsNode(value) == true){
			current = null;
			return current;
		}
		
	    if (value < current.value) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    if (current.left == null && current.right == null) {
	        return null;
	    }
	    if (current.right == null) {
	        return current.left;
	    }

	    if (current.left == null) {
	        return current.right;
	    }
	    int smallestValue = findSmallestValue(current.right);
	    current.value = smallestValue;
	    current.right = deleteRecursive(current.right, smallestValue);
	    return current;
	   
	}
	
	private static int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public static void delete(int value) {
	    deleteRecursive(getRoot(), value);
	}
	
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.value + "\n");
	        traverseInOrder(node.right);
	    }
	}
	
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.value + "\n");
	    }
	}
	
	public  void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.value + "\n");
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	


	public static Node getRoot() {
		return root;
	}

	public static void setRoot(Node root) {
		BynaryTree.root = root;
	}
}

