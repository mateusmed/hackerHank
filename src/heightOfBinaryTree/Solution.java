package src.heightOfBinaryTree;

import java.util.*;

class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {

        Integer valueLeft = null;
        Integer valueRigth = null;

        if(left != null){
            valueLeft = left.data;
        }

        if(right != null){
            valueRigth = right.data;
        }

        return "{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {


    /*
    class Node
        int data;
        Node left;
        Node right;

        no input tem dizer o numero de nos e os valores de cada no
        7
        4
        2
        6
        1
        3
        5
        7

              4
             / \
            2   6
           / \ / \
          1  3 5 7

    */
    public static int height(Node root) {
        // Write your code here.
        //root.
        System.out.println(root);

        return 0;
    }

    public static Node insert(Node root, int data) {

        if(root == null) {
            return new Node(data);
        }

        // se data menor ou igual ao valor principal do node insere a esquerda
        Node cur;
        if(data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
            return root;
        }

        // caso nao insere a direita
        cur = insert(root.right, data);
        root.right = cur;

        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}


