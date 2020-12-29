package lk.avix.practice.ProblemSolving.Trees;

import java.util.Scanner;

public class BinarySearchTreeInsertion {

    // Code is Given
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Code is Given
    public static void preOrder( Node root ) {
        if( root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root,int data) {
         if (root == null) {
             return new Node(data);
         }
        if (data >= root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    // Code is Given
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
