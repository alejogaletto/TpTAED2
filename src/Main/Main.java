package Main;
import Arbol.BynaryTree;
import VerticeyArista.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("-------------MENU----------------");
		System.out.println("Digité [1] para ingresar al Creador de grafo");
		System.out.println("Digité [2] para ingresar al creador de arbol");
		
		int opt = sc.nextInt();
		if(opt == 1) {
			Grafo grafo = new Grafo();
			String[] Vertices = {"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13"};
			grafo.addVertice(Vertices[0], Vertices[1], 200);
			grafo.addVertice(Vertices[0], Vertices[12], 250);
			grafo.addVertice(Vertices[0], Vertices[8], 290);
			grafo.addVertice(Vertices[1], Vertices[5], 360);
			grafo.addVertice(Vertices[1], Vertices[2], 190);
			grafo.addVertice(Vertices[2], Vertices[5], 250);
			grafo.addVertice(Vertices[2], Vertices[4], 190);
			grafo.addVertice(Vertices[2], Vertices[0], 300);
			grafo.addVertice(Vertices[3], Vertices[2], 180);
			grafo.addVertice(Vertices[4], Vertices[5], 300);
			grafo.addVertice(Vertices[4], Vertices[9], 400);
			grafo.addVertice(Vertices[5], Vertices[10], 350);
			grafo.addVertice(Vertices[5], Vertices[11], 300);
			grafo.addVertice(Vertices[6], Vertices[3], 300);
			grafo.addVertice(Vertices[6], Vertices[2], 250);
			grafo.addVertice(Vertices[6], Vertices[0], 150);
			grafo.addVertice(Vertices[7], Vertices[6], 200);
			grafo.addVertice(Vertices[7], Vertices[0], 220);
			grafo.addVertice(Vertices[8], Vertices[7], 180);
			grafo.addVertice(Vertices[8], Vertices[12], 180);
			grafo.addVertice(Vertices[9], Vertices[3], 200);
			grafo.addVertice(Vertices[10], Vertices[9], 700);
			grafo.addVertice(Vertices[10], Vertices[4], 200);
			grafo.addVertice(Vertices[11], Vertices[1], 150);
			grafo.addVertice(Vertices[12], Vertices[11], 100);
			grafo.addVertice(Vertices[12], Vertices[1], 200);

			grafo.seeGraph();
			grafo.dijkstra("d12", "d5");
			grafo.BFS("d12","d5");
			
			System.out.println("Grafos aciclicos: ");
			grafo.buscarGrafo();
		} else if(opt == 2) {
			BynaryTree btn = new BynaryTree();
			btn.createBynaryTree();
			while(true) {
				System.out.println("Oprima [1] si desea recorrer el arbol en PreOrder");
				System.out.println("Oprima [2] si desea recorrer el arbol en InOrder");
				System.out.println("Oprima [3] si desea recorrer el arbol en PostOrder");
				System.out.println("Oprima [4] si desea eliminar un nodo");
				
				int opc = sc.nextInt();
				switch(opc) {
				case 1:
					btn.traversePreOrder(BynaryTree.getRoot());
					break;
				case 2:
					btn.traverseInOrder(BynaryTree.getRoot());
					break;
				case 3:
					btn.traversePostOrder(BynaryTree.getRoot());
					break;
				case 4:
					System.out.println("Que nodo desea eliminar?");
					int chc = sc.nextInt();
					btn.delete(chc);
					System.out.println("Nodo eliminado");
					break;
			}

		}

		

	
		}
		
	}
}
