package Greedy;

import java.util.PriorityQueue;

public class OptimalMergePatterns {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int size = 6;
        int files[] = new int[] {2, 3, 4, 5, 6, 7};
        System.out.println("Minimum Computations = "+ minComputation(size, files));

    }

    private static int minComputation(int size, int[] files) {
        // TODO Auto-generated method stub
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<size;i++)
            pq.add(files[i]);
        int count = 0;
        while(pq.size()>1)
        {
            int temp = pq.poll() + pq.poll();
            count += temp;
            pq.add(temp);
        }
        return count;
    }

}
