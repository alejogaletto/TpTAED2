package VerticeyArista;

import java.util.LinkedList;
import java.util.List;

public class Vertice {
	public String name;
	public List<Arista> adyacente;
	public double dist;
	public Vertice prev;
	
	public Vertice(String nm) {
		name = nm;
		adyacente = new LinkedList<Arista>();
		reset();
	}
	
	public void reset() {
		dist = Grafo.INFINITY;
	}
}
