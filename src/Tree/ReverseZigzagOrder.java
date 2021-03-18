package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseZigzagOrder {
    Node root;

    void printReverseZigzagOrder() {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> s1 =new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Stack<ArrayList<Integer>> s3 = new Stack<>();
        s1.push(root);



        while(s1.empty() == false || s2.empty() == false) {

            while(s1.empty() == false) {
                Node curr = s1.peek();
                s1.pop();
                arr.add(curr.data);

                if(curr.right != null) {
                    s2.push(curr.right);
                }
                if(curr.left != null) {
                    s2.push(curr.left);
                }
            }

            if(arr.size()>0){

                s3.push(arr);
                arr = new ArrayList<>();

            while(s2.empty() == false) {
                Node curr = s2.peek();
                s2.pop();
                arr.add(curr.data);

                if(curr.left != null) {
                    s1.push(curr.left);
                }
                if(curr.right != null) {
                    s1.push(curr.right);
                }
            }
            if(arr.size()>0){

                s3.push(arr);
                arr = new ArrayList<>();
            }

          }


        }

        while(s3.empty() == false) {
            result.add(s3.peek());
            s3.pop();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseZigzagOrder tree = new ReverseZigzagOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printReverseZigzagOrder();

    }

}
