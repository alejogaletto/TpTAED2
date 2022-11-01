package VerticeyArista;


import java.util.List;
import java.util.LinkedList;

public class Vertice implements Comparable<Vertice> {
	public String nombre;
	public List<Arista> adyacente;
	public List<String> filaNC;
	public int dist;
	public Vertice prev;
	public Object destino;
	private boolean visitado;
	
	public Vertice(String nm)   {
		nombre = nm;
		adyacente = new LinkedList<Arista>();
		filaNC = new LinkedList<String>();
		reset();
		
	}
	
	public int compareTo(Vertice other) {
	    return Integer.compare(this.dist, other.dist);
	}
	
	public void reset() {
		dist = -1;
	}
	
	public boolean esVisitado() {
		return visitado;
	}
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
}
