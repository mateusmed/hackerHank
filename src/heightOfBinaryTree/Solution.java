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

        no input tem que dizer o numero de nos e os valores de cada no caso do codigo será montado em ordem
        lembra lá da faculdade? existe o caso de ordem, pré-ordem e pós-ordem

        7 - numero de nos
        4 - nó 0
        2 - nó 1
        6 - nó 2
        1 - nó 3
        3 - nó 4
        5 - nó 5
        7 - nó 6

input:
        7
        4
        2
        6
        1
        3
        5
        7

desenho para entendimento:
              4
             / \
            2   6
           / \ / \
          1  3 5  7

input:
        8
        4
        2
        6
        1
        3
        5
        7
        0

desenho para entendimento:
                4
               / \
              2   6
             / \ / \
            1  3 5 7
           /
          0
    */

    static int deepNodeLevelRigth = 0;
    static int deepNodeLevelLeft = 0;

    public static Node eachNode(Node mainNode){

        System.out.println("node content" + mainNode.data);

        if(mainNode.left != null){
            deepNodeLevelLeft++;
            eachNode(mainNode.left);
        }

        if(mainNode.right != null){
            deepNodeLevelRigth++;
            eachNode(mainNode.right);
        }

        return mainNode;
    }

    public static int height(Node root) {
        eachNode(root);

        System.out.println("deep node left: " + deepNodeLevelLeft);
        System.out.println("deep node rigth: " + deepNodeLevelRigth);

        if(deepNodeLevelLeft > deepNodeLevelRigth){
            return deepNodeLevelLeft;
        }
        return deepNodeLevelRigth;
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


