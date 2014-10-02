import java.util.HashMap;
import java.util.ArrayList;

public class Graph{
	ArrayList<Vertex> vertices;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}

	public void addVertex(Vertex v) {
		vertices.add(v);
	}

	public void addEdge(Vertex v1, Vertex v2) {
		// check if both exists
		v1.addNeighbor(v2);
		v2.addNeighbor(v1);
	}

	public void dfs(Vertex v) {
		v.visited = true;
		System.out.print(v.data + " ");
		ArrayList<Vertex> neighbors = v.getNeighbors();
		for(Vertex neighbor: neighbors) { 
			v = neighbor;
			if(v.visited == false) {
				dfs(v);
			}
		}

	}

	public void dfsStack(Vertex v) {
		for(Vertex vtx: vertices)
                        vtx.visited = false;
		Stack stack = new Stack();

		//v.visited = true;
		stack.push(v);
		
		while(!stack.isEmpty()) {
			v = stack.pop();
			v.visited = true;
			System.out.print(v.data+" ");
			for(Vertex vtx: v.getNeighbors()) {
				if(vtx.visited == false) {
					//vtx.visited = true;
					stack.push(vtx);
				}
			}
			
			v = stack.peek(); 
			while(!stack.isEmpty() && v.visited == true)
				v = stack.pop();
		}		

	}

	public void bfs(Vertex v) {
		for(Vertex vtx: vertices)
			vtx.visited = false;	
		
		// init queue
		Queue q = new Queue();
		v.visited = true;
		q.enqueue(v);

		while(!q.isEmpty()) {
			v = q.dequeue();
			System.out.print(v.data + " ");
			for(Vertex vtx: v.getNeighbors()) {
				if(vtx.visited == false) {
					vtx.visited = true;
					q.enqueue(vtx);
				}
			}			
		}

	}

	public String toString() {
		String s = "";
		for(Vertex v: vertices) {
			s += v.toString();
		}
		return s;
	}
}
