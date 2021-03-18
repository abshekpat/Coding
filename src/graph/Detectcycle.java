package graph;

public class Detectcycle {
	int V, E;
	Edge edge[];

	class Edge{
		int src, dest;
	}

	Detectcycle(int v, int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0;i<e;i++)
			edge[i] = new Edge();
	}

	int find(int parent[], int i)
	{
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void union(int parent[], int x, int y)
	{
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	int isCycle(Detectcycle graph) {
		// TODO Auto-generated method stub
		int parent[] = new int[graph.V];
		for(int i=0;i<graph.V;i++)
			parent[i] = -1;
		for(int i=0;i<graph.E;i++)
		{
			int x = graph.find(parent, graph.edge[i].src);
			int y = graph.find(parent, graph.edge[i].dest);
			if(x==1)
				return 1;
			graph.union(parent, x, y);
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3;
		Detectcycle graph = new Detectcycle(V, E);
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );

	}
}
