package graph;

public class Detectcycle1 {
	int V, E;
	Edge edge[];

	class Edge{
		int src, dest;
	}

	Detectcycle1(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0;i<E;i++)
			edge[i] = new Edge();
	}

	class subset{
		int parent, rank;
	}

	int find(subset subsets[], int i) {
		if(subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	void union(subset subsets[], int x, int y) {
		int xset = find(subsets, x);
		int yset = find(subsets, y);
		if(subsets[xset].rank < subsets[yset].rank)
			subsets[xset].parent = yset;
		else if(subsets[yset].rank< subsets[xset].rank)
			subsets[yset].parent = xset;
		else
		{
			subsets[xset].parent = yset;
			subsets[yset].rank++;
		}
	}

	int isCycle(Detectcycle1 graph)
	{
		subset subsets[] = new subset[graph.V];
		for(int i=0;i<graph.V;i++)
		{
			subsets[i] = new subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		for(int i=0;i<graph.E;i++)
		{
			int x = find(subsets, graph.edge[i].src);
			int y = find(subsets, graph.edge[i].dest);
			if(x==y)
				return 1;
			union(subsets, x, y);
		}
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3;
		Detectcycle1 graph = new Detectcycle1(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1)
		    System.out.println("Graph contains cycle");
		else
		    System.out.println("Graph doesn't contain cycle");

	}

}
