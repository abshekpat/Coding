/*
1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
 */

package Greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node2 implements Comparable<Node2>{
    int val, cost;
    Node2(int val, int cost){
        this.val = val; this.cost = cost;
    }

	public int compareTo(Node2 x){
        return Integer.compare(this.cost, x.cost);
    }
}


public class Dijkstra1 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Node2>> adj = new ArrayList<>(n+1);
            for(int i=0;i<n+1;i++)
                adj.add(new ArrayList<Node2>(n+1));
            while(m-- > 0){
                int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
                adj.get(x).add(new Node2(y, cost));
                adj.get(y).add(new Node2(x, cost));
            }
            int s = sc.nextInt();
            djikstra(s, adj, n);
        }
    }

    static void djikstra(int s, ArrayList<ArrayList<Node2>> adj, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Node2> pq = new PriorityQueue<Node2>();
        pq.add(new Node2(s, 0));
        while(pq.size()>0){
            Node2 curr = pq.peek();
            pq.remove();
            int currN = curr.val;
            Iterator<Node2> it =  adj.get(currN).iterator();
            while(it.hasNext()){
                Node2 temp = it.next();
                if(dist[temp.val] > dist[currN] + temp.cost){
                    pq.add(new Node2(temp.val, dist[currN]+temp.cost));
                    dist[temp.val] = dist[currN] + temp.cost;
                }
            }
        }
        for(int i=1; i<dist.length; i++){
            if(i!=s){
                System.out.print(((dist[i] == Integer.MAX_VALUE)?-1:dist[i]) + " ");
            }
        }
        System.out.println();
    }
    }
