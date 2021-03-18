package Greedy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Prims {

	class node1{
		int dest;
		int wt;
		node1(int dest, int wt)
		{
			this.dest = dest;
			this.wt = wt;
		}
	}

	static class Graph{
		int V;
		LinkedList<node1> adj[];
		@SuppressWarnings("unchecked")
		Graph(int e)
        {
            V = e;
            adj = new LinkedList[V];
            for (int o = 0; o < V; o++)
                adj[o] = new LinkedList<>();
        }
	}

	class node{
		int vertex;
		int key;
		}

	class comparator implements Comparator<node>{

		@Override
		public int compare(node node0, node node1)
		{
			return node0.key - node1.key;
		}
	}

  void addEdge(Graph graph, int src, int dest, int wt) {
		// TODO Auto-generated method stub
		node1 A = new node1(dest, wt);
		node1 B = new node1(src, wt);
		graph.adj[src].add(A);
		graph.adj[dest].add(B);

	}

	void prims_mst(Graph graph) {
		// TODO Auto-generated method stub
		Boolean mstset[] = new Boolean[graph.V];
		node[] e = new node[graph.V];
		int parent[] = new int[graph.V];

		for(int i=0;i<graph.V;i++)
			e[i] = new node();

		for(int i=0;i<graph.V;i++)
		{
			mstset[i] = false;
			e[i].key = Integer.MAX_VALUE;
			e[i].vertex = i;
			parent[i] = -1;
		}
		mstset[0] = true;
		e[0].key = 0;

		TreeSet<node> queue = new TreeSet<>(new comparator());

		for(int i=0;i<graph.V;i++)
			queue.add(e[i]);

		while(!queue.isEmpty())
		{
			node node0 = queue.pollFirst();
			mstset[node0.vertex] = true;
			for(node1 i : graph.adj[node0.vertex])
			{
				if(mstset[i.dest] == false)
				{
					if(e[i.dest].key > i.wt)
					{
						queue.remove(e[i.dest]);
						e[i.dest].key = i.wt;
						queue.add(e[i.dest]);
						parent[i.dest] = node0.vertex;
					}
				}
			}
		}
		for (int o = 1; o < graph.V; o++)
            System.out.println(parent[o] + " "
                               + "-"
                               + " " + o);
    }




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 9;
		Graph graph = new Graph(V);
		Prims e = new Prims();
		e.addEdge(graph, 0, 1, 4);
		e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.prims_mst(graph);


	}
}
