package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Jobsequencing {

    static class Job
    {
        char id;
        int dl;
        int pt;

        public Job(char id, int dl, int pt)
        {
            this.id = id;
            this.dl = dl;
            this.pt = pt;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char []id = {'a', 'b', 'c', 'd', 'e'};
        int []dl = {2, 1, 2, 1, 3};
        int []pt = {100, 19, 27, 25, 15};
        jobscheduling(id, dl, pt);

    }

    private static void jobscheduling(char[] id, int[] dl, int[] pt) {
        // TODO Auto-generated method stub
        Job[] jb = new Job[dl.length];
        for(int i=0; i<dl.length; i++) {
            jb[i] = new Job(id[i], dl[i], pt[i]);
        }
        Arrays.sort(jb, new Comparator<Job>()
        {
            @Override
            public int compare(Job j1, Job j2)
            {
                if(j1.pt != j2.pt)
                    return j2.pt - j1.pt;
                else
                    return  j2.dl - j1.dl;

            }
        });

        int totalprofit = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0; i<dl.length; i++) {
            ts.add(i);
        }

        for(int i=0; i<dl.length; i++)
        {
            Integer x = ts.floor(jb[i].dl-1);
            if(x != null)
            {
                System.out.print(jb[i].id+" ");
                ts.remove(x);
                totalprofit += jb[i].pt;
            }
        }

        System.out.println("\n"+"Total profit is : " +totalprofit);

    }

}
