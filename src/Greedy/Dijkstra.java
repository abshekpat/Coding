package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;
	private int V;
	List<List<Node>> adj;

	public Dijkstra(int V)
	{
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	public void dij_algo(List<List<Node>> adj, int src)
	{
		this.adj = adj;
		for(int i=0; i<V; i++)
			dist[i] = Integer.MAX_VALUE;
		pq.add(new Node(src, 0));
		dist[src] = 0;
		while(settled.size()!=V)
		{
			int u = pq.remove().node;
			settled.add(u);
			e_Neighbours(u);
		}
	}

	private void e_Neighbours(int u)
	{
		int editDistance = -1;
		int newDistance = -1;

		for(int i=0;i<adj.get(u).size(); i++)
		{
			Node v = adj.get(u).get(i);
			if(!settled.contains(v))
			{
				editDistance = v.cost;
				newDistance = dist[u] + editDistance;
				if(newDistance < dist[v.node])
					dist[v.node] = newDistance;
				pq.add(new Node(v.node, dist[v.node]));
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=5;
		int source =0;
		List<List<Node>> adj = new ArrayList<List<Node>>();
		for(int i=0;i<V;i++) {
			List<Node> item = new ArrayList();
			adj.add(item);
		}
		adj.get(0).add(new Node(1, 9));
		adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        Dijkstra dpq = new Dijkstra(V);
        dpq.dij_algo(adj, source);

        System.out.println("The shorted path from node :");
        for(int i=0;i<dpq.dist.length;i++)
        	System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);

	}

}
class Node implements Comparator<Node>{
	public int node;
	public int cost;
	public Node()
	{

	}
	public Node(int node, int cost)
	{
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compare(Node n1, Node n2)
	{
		return n1.cost-n2.cost;
	}
}
