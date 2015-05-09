package hw5;

public class Edge {
	public int nodeNum; // at end of edge
	public Edge nextEdge; // next in adj list
	public Edge () 
	{
		nextEdge = null;
	}

	public Edge(int num, Edge e) {
		nodeNum = num;
		nextEdge = e;
		// initialize other edge info here
	}
}