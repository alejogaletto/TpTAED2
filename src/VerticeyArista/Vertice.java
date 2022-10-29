package VerticeyArista;


import java.util.List;
import java.util.LinkedList;

public class Vertice implements Comparable<Vertice> {
	public String name;
	public List<Arista> adjacente;
	public int dist;
	public Vertice prev;
	public Object destino;
	
	public Vertice(String nm)   {
		name = nm;
		adjacente = new LinkedList<Arista>();
		reset();
		
	}
	
	public int compareTo(Vertice other) {
	    return Integer.compare(this.dist, other.dist);
	}
	
	public void reset() {
		dist = -1;
	}
}
