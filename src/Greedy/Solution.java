package Greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node3 implements Comparable<Node3>{
    int val, cost;
    Node3(int val, int cost)
    {
        this.val = val;
        this.cost = cost;
    }
    public int compareTo(Node3 x)
    {
        return Integer.compare(this.cost, x.cost);
    }

}

public class Solution {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Node3>> adj = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<Node3>(n+1));
        while(m-- > 0)
        {
            int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
            adj.get(x).add(new Node3(y, cost));
//            System.out.println("x ki value  "+adj.get(x));
            adj.get(y).add(new Node3(x, cost));
        }
            int s = sc.nextInt();
            prims(s, adj, n);

    }

    static void prims(int s, ArrayList<ArrayList<Node3>> adj, int n)
    {
        Boolean mstset[] = new Boolean[n+1];
        int parent[] = new int[n+1];
        Node3 dist[] = new Node3[n+1];
        for(int i=0;i<n+1;i++)
        {
        		dist[i] = new Node3(i, Integer.MAX_VALUE);
        }
        Arrays.fill(mstset, false);
        Arrays.fill(parent, -1);
        mstset[s] = true;
        dist[s].cost = 0;
        TreeSet<Node3> queue = new TreeSet<Node3>();
        for(int i=1;i<n+1;i++)
            queue.add(dist[i]);
        while(!queue.isEmpty())
        {
            Node3 curr = queue.pollFirst();
            int currN = curr.val;
            mstset[currN] = true;
            Iterator<Node3> it = adj.get(currN).iterator();
            while(it.hasNext())
            {
                Node3 temp = it.next();
                if(mstset[temp.val] == false)
                {
                    if(dist[temp.val].cost > temp.cost)
                    {
                        queue.remove(dist[temp.val]);
                        dist[temp.val].cost = temp.cost;
                        queue.add(dist[temp.val]);
                        parent[temp.val] = currN;

                    }
                }
            }
        }
        int count=0;
        for(int i=1; i<dist.length; i++){
            count += dist[i].cost;
        }
        System.out.println();

    }

}

