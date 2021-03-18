package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    Node root;

    void printverticalorder() {
        Queue<Object> q = new LinkedList<>();
        q.add(root);
        q.add(0);

        TreeMap<Integer, ArrayList<Integer>> hash = new TreeMap<>();

        while(q.isEmpty() == false) {
            Node curr = (Node)q.poll();
            int x = (int)q.poll();

            if(curr.left != null) {
                q.add(curr.left);
                q.add(x-1);
            }

            if(curr.right != null) {
                q.add(curr.right);
                q.add(x+1);
            }

            if(hash.containsKey(x) == false) {
                hash.put(x, new ArrayList<Integer>());
            }
            hash.get(x).add(curr.data);
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : hash.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printverticalorder();

    }

}
