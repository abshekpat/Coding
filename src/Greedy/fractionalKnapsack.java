package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int []wt = {10, 40, 20, 30};
        int []vl = {60, 40, 100, 120};
        int capacity = 50;
        double maxValue = getMaxvalue(wt, vl, capacity);
        System.out.println("Maximum value we can obtain = " +
                maxValue);
        }

    private static double getMaxvalue(int[] wt, int[] vl, int capacity)
    {
        Itemvalue[] ival = new Itemvalue[wt.length];
        for(int i=0; i<wt.length; i++) {
            ival[i] = new Itemvalue(wt[i], vl[i], i);
        }
        Arrays.sort(ival, new Comparator<Itemvalue>()
        {
            @Override
            public int compare(Itemvalue o1, Itemvalue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }

         });

        double totalvalue = 0d;
        for(Itemvalue i: ival)
        {
            int curwt = i.wt;
            int curval = i.vl;

            if(capacity - curwt >= 0)
            {
                capacity -= curwt;
                totalvalue += curval;
            }
            else
            {
                double fraction = ((double) capacity / (double) curwt);
                totalvalue += (curval * fraction);
            }
        }
        return totalvalue;

    }

    static class Itemvalue{
        Double cost;
        int wt, vl, ind;

        public Itemvalue(int wt, int vl, int ind)
        {
            this.wt = wt;
            this.vl = vl;
            this.ind = ind;
            cost = new Double(vl/wt);
        }
    }

}
