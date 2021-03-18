package Greedy;

import java.util.Arrays;

public class Kruskal {

	class Edge implements Comparable<Edge>{
		int src, dest, wt;
		public int compareTo(Edge compareEdge)
		{
			return this.wt - compareEdge.wt;
		}
	};

	int V;
	int E;
	Edge edge[];
	Kruskal(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0;i<e;i++)
			edge[i] = new Edge();
	}

	class subset
    {
        int parent, rank;
    };

    int find(subset subsets[], int i)
    {
    		if(subsets[i].parent != i)
    			subsets[i].parent = find(subsets, subsets[i].parent);
    		return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
    	    int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if(subsets[xroot].rank<subsets[yroot].rank)
        		subsets[xroot].parent = yroot;
        else if(subsets[yroot].rank<subsets[xroot].rank)
        	    subsets[yroot].parent = xroot;
        else
        {
        	    subsets[yroot].parent = xroot;
        	    subsets[xroot].rank++;
        }
    }

    void KruskalMST()
    {
    	    Edge result[] = new Edge[V];
    	    int i=0, e=0;
    	    for(i=0;i<V;i++)
    	    		result[i] = new Edge();
    	    Arrays.sort(edge);
    	    subset subsets[] = new subset[V];
    	    for(i=0; i<V; ++i)
            subsets[i]=new subset();
    	    for(i=0; i<V; ++i)
    	    {
    	    		subsets[i].parent = i;
    	    		subsets[i].rank = 0;
     	}
    	    i=0;
    	    while(e<V-1)
    	    {
    	    		Edge nextEdge = new Edge();
    	    		nextEdge = edge[i++];
    	    		int x = find(subsets, nextEdge.src);
    	    		int y = find(subsets, nextEdge.dest);
    	    		if(x!=y)
    	    		{
    	    			result[e++] = nextEdge;
    	    			Union(subsets, x, y);
    	    		}

    	    }
    	    System.out.println("Following are the edges in " +
                    "the constructed MST");
        for (i = 0; i < e; ++i)

        System.out.println(result[i].src+" -- " +
         result[i].dest+" == " + result[i].wt);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		int E = 5;
		Kruskal graph = new Kruskal(V, E);
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].wt = 10;

		graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].wt = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].wt = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].wt = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].wt = 4;

        graph.KruskalMST();

	}
}
