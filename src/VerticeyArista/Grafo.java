package VerticeyArista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;


public class Grafo   {
	
	private Map<String, Vertice>VerticeMap = new HashMap<String,Vertice>();
	
	public Vertice getVertice(String VerticeName) {
		Vertice v = VerticeMap.get(VerticeName);
		return v;
	}
	
	public void addVertice(String VerticeName,String VerticeName2, int cost) {
		Vertice v = VerticeMap.get(VerticeName);
		Vertice m = VerticeMap.get(VerticeName2);
		if(v == null) {
			v = new Vertice(VerticeName);
			VerticeMap.put(VerticeName,v);
			System.out.println("Vertice: "+ VerticeName +" no encontrado, se creo el vertice indicado");
		}
		if(m == null) {
			v = new Vertice(VerticeName2);
			VerticeMap.put(VerticeName2,v);
			System.out.println("Vertice"+ VerticeName2 +" no encontrado, se creo el vertice indicado");
		}	
		agregarArista(VerticeName, VerticeName2, cost);
		
			
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
					imprimirTodos(valr1, valr2);
				}
			}
		}
	}
	
	public void dijkstra(String inicioName, String destino) {
		clearAll();
		Vertice inicio = VerticeMap.get(inicioName);
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
			System.out.println("La suma de los pesos del camino mas corto entre " + inicioName+ " y " + fin.nombre + " es: " + fin.dist);
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
	
	public void imprimirTodos(Vertice v, Vertice n) {
		ArrayList<String> listaCaminos = new ArrayList<>();
		listaCaminos.add(v.nombre);
		caminosAciclicos(v,n,listaCaminos);
	}
	
	private void caminosAciclicos(Vertice j, Vertice t, List<String> localPathList) {
		if(j.equals(t)) {
			System.out.println(localPathList);
			return;
		}
		
		j.setVisitado(true);
		
		for(Arista i : j.adyacente) {
			if(!i.destino.esVisitado()) {
				localPathList.add(i.destino.nombre);
				caminosAciclicos(i.destino, t, localPathList);
				localPathList.remove(i.destino.nombre);
			}
		}
		j.setVisitado(true);
	}
	
	
	public void agregarArista(String nomOri, String nomDest, int cost) {
		Vertice v = getVertice(nomOri);
		Vertice w = getVertice(nomDest);
		v.adyacente.add(new Arista(w,cost));

		
	}
}