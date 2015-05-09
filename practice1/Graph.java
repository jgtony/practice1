package hw5;

//Graph.java: set up graphs data structure
//Uses adjacency list representation

public class Graph {
	public int N; 
	public int [][]map;

	public Graph(int n) {
		N = n;
		map = new int[N][N];		
	}

	// insertEdge: insert directed edge
	public void insertbcc(int tail, int head) {
		map[head][tail] = 1;
		map[tail][head] = 1;
	}
	public void insertscc(int tail,int head)
	{
		map[head][tail] = 1;
		
	}
	
	// return the number of nodes in graph
	public int V() {
		return N;
	}
	
	// return node n's adjacency node ids.
	public int[] adj(int n) {
		int []adjs = new int[V()];
		int count =0;
		for(int i=0;i<V();i++)
		{
			if(map[n][i]==1||map[i][n]==1)
				adjs[count++] = i;
		}		
		return adjs;
	}
}