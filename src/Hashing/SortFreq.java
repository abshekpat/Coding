package Hashing;

/*package whatever //do not write package name here */

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;
import java.util.Comparator;

class SortFreq {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		        arr[i] = sc.nextInt();
		    Map<Integer, Integer> map = new HashMap<>();
		    HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
		    List<Integer> outputArray = new ArrayList<>();
		    for(int i=0;i<n;i++)
		    {
		        if(!map.containsKey(arr[i]))
		            map.put(arr[i], 1);
		        else{
		            int x = map.get(arr[i]);
		            x++;
		            map.put(arr[i], x);
		        }
		        outputArray.add(arr[i]);
		    }

		    Iterator<Map.Entry<Integer, Integer>> itr1 = map.entrySet().iterator();
		    while(itr1.hasNext())
		    {
		      Map.Entry<Integer, Integer> entry = itr1.next();
		      System.out.println("Key = " + entry.getKey() +
                                 ", Value = " + entry.getValue());
		    }


		    Collections.sort(outputArray, new Comparator<Integer>()
		    {
		     	public int compare(Integer x, Integer y)
			    {
			        int value = map.get(y).compareTo(map.get(x));
			        /*int  key = y.compareTo(x);
			        if(value==0)
			            return key;
			        else*/
			            return value;
			    }
		    });
		    System.out.println(outputArray);

		    for(int i=0;i<n;i++)
		    {
		        if(!sortedMap.containsKey(outputArray.get(i)))
		        	   sortedMap.put(outputArray.get(i), 1);
		        else{
		            int y = sortedMap.get(outputArray.get(i));
		            sortedMap.put(outputArray.get(i), ++y);
		        }

		    }

		    System.out.println(sortedMap);
		}
	}

}
