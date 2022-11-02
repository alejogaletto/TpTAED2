package Arbol;

public class BynaryTree {
	private static Node raiz;
	
	private Node agregarRec(Node actual, int valor) {
		if(actual == null) {
			return new Node(valor);
		}
		
		if(valor < actual.value) {
			actual.left = agregarRec(actual.left, valor);
		} else if(valor > actual.value) {
			actual.right = agregarRec(actual.right, valor);
		} else {
			return actual;
		}
		return actual;
	}
	
	public void agregar(int valor) {
		raiz = agregarRec(getraiz(), valor);
	}
	
	public BynaryTree crearArbol() {
		BynaryTree bt = new BynaryTree();
		
	    bt.agregar(6);
	    bt.agregar(4);
	    bt.agregar(8);
	    bt.agregar(3);
	    bt.agregar(5);
	    bt.agregar(7);
	    bt.agregar(9);

	    return bt;
	}
	
	public static boolean contNodoRec(Node actual, int valor) {
		if(actual == null) {
			return false;
		}if(valor == actual.value) {
			return true;
		}
		return valor < actual.value ? contNodoRec(actual.left, valor) :  contNodoRec(actual.right, valor);  
	}
	
	public static boolean contNodo(int valor) {
		return contNodoRec(getraiz(), valor);
	}
	
	private Node eliminarRec(Node actual, int valor) {
	    if (actual == null) {
	        return null;
	    }
	    
	    if(valor == actual.value) {
	    	if (actual.left == null && actual.right == null) {
	    	    return null;
	    	}
	    	
	    	if (actual.right == null) {
	    	    return actual.left;
	    	}

	    	if (actual.left == null) {
	    	    return actual.right;
	    	}
		    int smallestvalor = encontrarMenor(actual.right);
		    actual.value = smallestvalor;
		    actual.right = eliminarRec(actual.right, smallestvalor);
		    return actual;
	    }
		
	    if (valor < actual.value) {
	        actual.left = eliminarRec(actual.left, valor);
	        return actual;
	    }
	    actual.right = eliminarRec(actual.right, valor);
	    return actual;
	}
	
	private static int encontrarMenor(Node raiz) {
		return raiz.left == null ? raiz.value : encontrarMenor(raiz.left);
	}
	
	public void eliminar(int valor) {
	    raiz = eliminarRec(raiz, valor);
	}
	
	public void recorrerInOrder(Node node) {
	    if (node != null) {
	        recorrerInOrder(node.left);
	        System.out.print(" " + node.value + "\n");
	        recorrerInOrder(node.right);
	    }
	}
	
	public void recorrerInPostOrder(Node node) {
	    if (node != null) {
	        recorrerInPostOrder(node.left);
	        recorrerInPostOrder(node.right);
	        System.out.print(" " + node.value + "\n");
	    }
	}
	
	public  void recorrerInPreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.value + "\n");
	        recorrerInPreOrder(node.left);
	        recorrerInPreOrder(node.right);
	    }
	}
	


	public static Node getraiz() {
		return raiz;
	}

	public static void setraiz(Node raiz) {
		BynaryTree.raiz = raiz;
	}
}

