
public class GraphTest {

	public static void main(String args[]) {
		Graph g = new Graph();
		Vertex[] n = new Vertex[8];

		for(int i = 0; i <= 7; i++) {
			n[i] = new Vertex(i);
			g.addVertex(n[i]);
		}

		g.addEdge(n[0], n[1]);
		g.addEdge(n[0], n[3]);
		g.addEdge(n[0], n[6]);
		g.addEdge(n[1], n[4]);
		g.addEdge(n[1], n[5]);
		g.addEdge(n[2], n[5]);
		g.addEdge(n[2], n[7]);
		g.addEdge(n[3], n[5]);
		g.addEdge(n[4], n[6]);

		System.out.println(g.toString());

		g.dfs(n[0]);
		System.out.println();
		g.bfs(n[0]);
		System.out.println();
		g.dfsStack(n[0]);
		System.out.println();
	}
}
