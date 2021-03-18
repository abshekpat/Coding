package dp;

import java.util.Arrays;
import java.util.Scanner;
public class Knapsack1{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t>0){
			int n=in.nextInt();
			int k=in.nextInt();
			int[] c=new int[n];
			int[] dp=new int[k+2];
			for(int i=0;i<n;i++){
				c[i]=in.nextInt();
			}
			Arrays.sort(c);
			//int y=0;y<n; y++
			for (int y=0;y<n; y++)
		    {
				for (int g=1;g<=k; g++)
		        {
		            if (c[y]>g) continue;
		            dp[g]=Math.max(dp[g], c[y]+dp[g-c[y]]);
		        }
		    }
			System.out.println(dp[k]);
			t--;
		}
	}
}