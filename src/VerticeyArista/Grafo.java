package VerticeyArista;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Grafo   {
	
	private Map<String, Vertice>VerticeMap = new HashMap<String,Vertice>();
	
	public Vertice getVertice(String Verticenombre) {
		Vertice v = VerticeMap.get(Verticenombre);
		return v;
	}
	
	public void addVertice(String Verticenombre,String Verticenombre2, int cost) {
		Vertice v = VerticeMap.get(Verticenombre);
		Vertice m = VerticeMap.get(Verticenombre2);
		if(v == null) {
			v = new Vertice(Verticenombre);
			VerticeMap.put(Verticenombre,v);
			System.out.println("Vertice: "+ Verticenombre +" no encontrado, se creo el vertice indicado");
		}
		if(m == null) {
			v = new Vertice(Verticenombre2);
			VerticeMap.put(Verticenombre2,v);
			System.out.println("Vertice"+ Verticenombre2 +" no encontrado, se creo el vertice indicado");
		}	
		agregarArista(Verticenombre, Verticenombre2, cost);
		
			
	}
	
	public void seeGraph() {
		if(VerticeMap != null) {
			for(Map.Entry<String, Vertice> entry : VerticeMap.entrySet()) {
				System.out.println("Vertice: " + entry.getKey());
				for (Arista e : entry.getValue().adyacente) {
					System.out.println("  -Se dirige a: "+ e.destino.nombre + "(" + e.costo +")");
				}
			}
		} else {
			System.out.println("No existen vertices ni aristas en este grafo");
		}
	}
	
	public void buscarGrafo() {
		for(Vertice valr1 : VerticeMap.values()) {
			for(Vertice valr2 : VerticeMap.values()) {
				clearAll();
				if(valr2 != valr1) {
					Allcaminos(valr1, valr2);
				}
			}
		}
	}
	
	public void dijkstra(String inicionombre, String destino) {
		clearAll();
		Vertice inicio = VerticeMap.get(inicionombre);
		Vertice fin = VerticeMap.get(destino);

		inicio.dist = 0;
		
		Queue<Vertice> pq = new LinkedList<Vertice>();
		
		pq.add(inicio);
		while(!pq.isEmpty() ) {
			Vertice v = pq.remove();
			for(Arista e : v.adyacente) {
			Vertice w = e.destino;
			int cVW = (int) e.costo;

		
			if( w.dist == -1) {

				w.dist = v.dist + cVW;
				w.prev = v;
				pq.add(w);}
			else if (w.dist > v.dist + cVW) {
				w.dist = v.dist + cVW;
				w.prev = v;
				pq.add(w);
				}
			
			
			}
		}
		if (fin.dist != -1) {
			System.out.println("La suma de los pesos del camino mas corto entre " + inicionombre+ " y " + fin.nombre + " es: " + fin.dist);
		}else System.out.println("No hay camino entre estos Vertices");
	}
	
	public void BFS(String inicio, String destino) {
		clearAll();
		Vertice start = VerticeMap.get(inicio);
		Vertice fin = VerticeMap.get(destino);

		
		Queue<Vertice> q = new LinkedList<Vertice>();
		q.add(start);
		start.dist = 0;
		
		while (!q.isEmpty()) {
			Vertice v = q.remove();
			
			for( Arista e : v.adyacente) {
				Vertice w = e.destino;
				if (w.dist == -1) {
					w.dist = v.dist + 1;
					w.prev = v;
					q.add(w);
				}
			}
		}
		if (fin.dist != -1) {
			System.out.println("La distancia entre " + inicio+ " y " + fin.nombre + " es: " + fin.dist);
		}else System.out.println("No hay camino entre estos Vertices");
	}
	
	private void clearAll() {
		for (Entry<String, Vertice> e : VerticeMap.entrySet()) {
			e.getValue().dist = -1;
			e.getValue().setVisitado(false);
		}  
	}
	
	 private Stack<String> camino  = new Stack<String>();  
	    private Set<String> onCamino  = new HashSet<String>();    
	    public void Allcaminos(Vertice S, Vertice R) {
	        numerar(S,R);
	    }

	    public void numerar(Vertice S, Vertice T) {

	        camino.push(S.nombre);
	        onCamino.add(S.nombre);

	        if (S.nombre.equals(T.nombre))
	            System.out.println(camino);

	        else {
	            for (Arista w : S.adyacente) {
	                if (!onCamino.contains(w.destino.nombre)) numerar(w.destino,T);
	            }
	        }

	        camino.pop();
	        onCamino.remove(S.nombre);
	    }
	
	
	public void agregarArista(String nomOri, String nomDest, int cost) {
		Vertice v = getVertice(nomOri);
		Vertice w = getVertice(nomDest);
		v.adyacente.add(new Arista(w,cost));

		
	}
}