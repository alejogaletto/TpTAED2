package VerticeyArista;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Grafo {
	public static final double INFINITY = Double.MAX_VALUE;
	private Map<String, Vertice> VerticeMap = new HashMap<String,Vertice>();
	
	public void agregarArista(String nomOri, String nomDest, double cost) {
		Vertice v = getVertice(nomOri);
		Vertice w = getVertice(nomDest);
		v.adyacente.add(new Arista(w, cost));
	}
	
	private Vertice getVertice(String VerticeName) {
		Vertice v = VerticeMap.get(VerticeName);
		if(v == null) {
			v = new Vertice(VerticeName);
			VerticeMap.put(VerticeName, v);
		}
		return v;
	}
	
	public void BFS(String startName) {
		//clearAll();
		Vertice start = VerticeMap.get(startName);
		
		Queue<Vertice> q = new LinkedList<Vertice>();
		q.add(start);
		start.dist = 0;
		
		while(!q.isEmpty()) {
			Vertice v = q.remove();
			
			for(Arista e : v.adyacente) {
				Vertice w = e.destino;
				if(w.dist == INFINITY) {
					w.dist = v.dist +1;
					w.prev = v;
					q.add(w);
				}
			}
		}
	}
	
	public void DSF(String origen) {
		DFS_Visita(origen);
	}
	
	public void DFS_Visita(String startName) {
		Vertice v = VerticeMap.get(startName);
		if(v.dist == INFINITY) {
			v.dist = 0;
			for(Arista e : v.adyacente) {
				Vertice w = e.destino;
				if(w.dist == INFINITY) {
					w.prev = v;
					DFS_Visita(w.name);
				}
			}
		}
	}
	
	public void dijkstra(String startName) {
		Vertice start = VerticeMap.get(startName);
		start.dist = 0;
		
		PriorityQueue<Vertice> pq = new PriorityQueue<Vertice>();
		
		pq.add(start);
		while(!pq.isEmpty()) {
			Vertice v = pq.remove();
			for(Arista e : v.adyacente) {
				Vertice w = e.destino;
				double cVW = e.costo;
				if(w.dist > v.dist + cVW) {
					w.dist = v.dist + cVW;
					w.prev = v;
					pq.add(w);
				}
			}
		}
	}
	
	
	public void seeGraph() {
		if(VerticeMap != null) {
			for(Map.Entry<String, Vertice> entry : VerticeMap.entrySet()) {
				System.out.println("Vertice: " + entry.getValue());
			}
		} else {
			System.out.println("No existen vertices ni aristas en este nodo");
		}
	}
	
}
