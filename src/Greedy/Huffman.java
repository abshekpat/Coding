package Greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


class HuffmanNode{
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>
{
    public int compare (HuffmanNode x, HuffmanNode y)
    {
        return x.data-y.data;
    }
}

public class Huffman {

    static HashMap<Character, String> codes = new HashMap<>();

    private static void printCode(HuffmanNode root, String string) {
        // TODO Auto-generated method stub
        if(root.left == null && root.right == null &&  Character.isLetter(root.c))
        {
            System.out.println(root.c+" : "+string);
            codes.put(root.c, string);
            return;
        }
        printCode(root.left, string+"0");
        printCode(root.right, string+"1");

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(n, new MyComparator());

        for(int i=0;i<n;i++)
        {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            pq.add(hn);
        }

        HuffmanNode root = null;
        while(pq.size()>1)
        {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            pq.add(f);

        }
        printCode(root, "");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<charfreq[i];j++)
                System.out.print(codes.get(charArray[i]));
            System.out.println();
        }

    }





}
