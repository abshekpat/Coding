package dp;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Knapsack {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0)
		{
		    int n = sc.nextInt();
		    int W = sc.nextInt();
		    int wt[] = new int[n+1];
		    int vl[] = new int[n+1];
		    wt[0] = 0;
		    vl[0] = 0;
		    for(int i=1;i<=n;i++)
		        wt[i] = sc.nextInt();
		    for(int i=1;i<=n;i++)
		        vl[i] = sc.nextInt();
		    int K[][] = new int[n+1][W+1];
		    for(int i=0;i<=n;i++)
		    {
		        for(int j=0;j<=W;j++)
		        {
		            if(i==0 || j==0)
		                K[i][j] = 0;
		            else if(wt[i]<=j)
		            {
		                K[i][j] = Integer.max(vl[i]+K[i-1][j-wt[i]], K[i-1][j]);
		            }
		            else
		                K[i][j] = K[i-1][j];
		        }
		    }
		    System.out.println(K[n][W]);

		}
	}
}