package VerticeyArista;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

public class Grafo   {
	
	private Map<String, Vertice>VerticeMap = new HashMap<String,Vertice>();
	Scanner s = new Scanner(System.in);

	
	public Vertice getVertice(String VerticeName) {
		Vertice n = VerticeMap.get(VerticeName);
		return n;
	}
	
	public void addVertice(String VerticeName,String VerticeName2, int cost) {
		Vertice n = VerticeMap.get(VerticeName);
		Vertice m = VerticeMap.get(VerticeName2);
		if(n == null) {
			n = new Vertice(VerticeName);
			VerticeMap.put(VerticeName,n);
			System.out.println("Vertice"+ VerticeName +" no encontrado... nuevo Vertice creado");
		}
		if(m == null) {
			n = new Vertice(VerticeName2);
			VerticeMap.put(VerticeName2,n);
			System.out.println("Vertice"+ VerticeName2 +" no encontrado... nuevo Vertice creado");
		}	
		agregarArista(VerticeName, VerticeName2, cost);
		
			
	}

	
	
	public void seeGraph() {
		if(VerticeMap != null) {
			for(Map.Entry<String, Vertice> entry : VerticeMap.entrySet()) {
				System.out.println("Vertice: " + entry.getKey());
				for (Arista e : entry.getValue().adjacente) {
					System.out.println("  -Apunta a: "+ e.destino.name + "(" + e.costo +")");
				}
			}
		} else {
			System.out.println("No existen vertices ni aristas en este grafo");
		}
	}
	
	
	public void dijkstra(String startName, String destino) {
		clearAll();
		Vertice start = VerticeMap.get(startName);
		Vertice end = VerticeMap.get(destino);

		start.dist = 0;
		
		Queue<Vertice> pq = new LinkedList<Vertice>();
		
		pq.add(start);
		while(!pq.isEmpty() ) {
			Vertice v = pq.remove();
			for(Arista e : v.adjacente) {
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
		if (end.dist != -1) {
			System.out.println("La suma de los pesos del camino mas corto entre " + startName+ " y " + end.name + " es: " + end.dist);
		}else System.out.println("No hay camino entre estos Vertices");
	}
	
	public void BFS(String startName, String destino) {
		clearAll();
		Vertice start = VerticeMap.get(startName);
		Vertice end = VerticeMap.get(destino);

		
		Queue<Vertice> q = new LinkedList<Vertice>();
		q.add(start);
		start.dist = 0;
		
		while (!q.isEmpty()) {
			Vertice v = q.remove();
			
			for( Arista e : v.adjacente) {
				Vertice w = e.destino;
				if (w.dist == -1) {
					w.dist = v.dist + 1;
					w.prev = v;
					q.add(w);
				}
			}
		}
		if (end.dist != -1) {
			System.out.println("La distancia entre " + startName+ " y " + end.name + " es: " + end.dist);
		}else System.out.println("No hay camino entre estos Vertices");
	}
	
	private void clearAll() {
		for (Entry<String, Vertice> e : VerticeMap.entrySet()) {
			e.getValue().dist = -1;
		}  
	}
	
	public void agregarArista(String nomOri, String nomDest, int cost) {
		Vertice v = getVertice(nomOri);
		Vertice w = getVertice(nomDest);
		v.adjacente.add(new Arista(w,cost));
		
	
		
	}
}