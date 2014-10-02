import java.util.HashMap;
import java.util.ArrayList;
public class Vertex {
	
	int data;
	boolean visited;
	//private HashMap<Integer, Node> neighbors;
	ArrayList<Vertex> neighbors;
	public Vertex(int v) {
		this.data = v;
		this.visited = false;
		//neighbors = new HashMap<Integer, Node>();
		neighbors = new ArrayList<Vertex>();	
	}

	public int getData() {
		return this.data;
	}

	/*public HashMap<Integer, Node> getNeighbors() {
		return this.neighbors;
	}*/
	public ArrayList<Vertex> getNeighbors() {
		return this.neighbors;
	}

	public void addNeighbor(Vertex v) {
		//neighbors.put(n.data, n);
		neighbors.add(v);
	}

	public String toString() {
		String s = "";
		s = this.data + " -- ";
		for(Vertex v: neighbors) {
			s += v.data + "-";
		}
		s += "\n";
	
		return s;
	}
}
