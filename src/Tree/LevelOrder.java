package Tree;
import java.util.*;

public class LevelOrder {
    Node root;

    void printlevelorder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false) {

            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null) {
                q.add(temp.left);
            }

            if(temp.right != null) {
                q.add(temp.right);
            }

        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LevelOrder tree = new LevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printlevelorder();


    }

}
