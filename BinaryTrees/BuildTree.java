package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static class BinaryTree{
        static int idx = -1;
        Node root = null;
        public Node preOrderBuildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = preOrderBuildTree(nodes);
            newNode.right = preOrderBuildTree(nodes);
            return newNode;
        }
    }

    public static void preOrderPrintTree(Node root){
        if(root == null){
            System.out.print(-1 + " ");
            return;
        }
        
        System.out.print(root.data + " ");
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
    }
    public static void inOrderPrintTree(Node root){
        if(root == null){
            System.out.print(-1 + " ");
            return;
        }
        
        inOrderPrintTree(root.left);
        System.out.print(root.data + " ");
        inOrderPrintTree(root.right);
    }
    public static void postOrderPrintTree(Node root){
        if(root == null){
            System.out.print(-1 + " ");
            return;
        }
        
        postOrderPrintTree(root.left);
        postOrderPrintTree(root.right);
        System.out.print(root.data + " ");
    }

    public static void leverOrderPrintTree(Node root){
        if(root == null){
            System.out.print("null ");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int getHeight(Node root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public static int countNodes(Node root){
        if(root==null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public static int sumOfNodes(Node root){
        if(root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }
    public static int getDiameter(Node root){ // O(n^2)
        if(root == null) return 0;
        int leftDia = getDiameter(root.left);
        int rightDia = getDiameter(root.right);
        int currDia = getHeight(root.left) + getHeight(root.right) + 1;
        return Math.max(currDia, Math.max(leftDia, rightDia));
    }
    static class Info{
        public int height, diameter;
        Info(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
    public static Info getDiameterInBigOofN(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info left = getDiameterInBigOofN(root.left);
        Info right = getDiameterInBigOofN(root.right);
        return new Info(Math.max(left.height, right.height)+1, Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter)));
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        bt.root = bt.preOrderBuildTree(nodes);
        // preOrderPrintTree(bt.root);
        // System.out.println();
        // inOrderPrintTree(bt.root);
        // System.out.println();
        // postOrderPrintTree(bt.root);
        // System.out.println();

        leverOrderPrintTree(bt.root);
        System.out.println("The height of Binary Tree: " + getHeight(bt.root));
        System.out.println("The number of nodes: " + countNodes(bt.root));
        System.out.println("The sum of nodes: " + sumOfNodes(bt.root));
        System.out.println("The diameter of Binary Tree: " + getDiameter(bt.root));
        System.out.println("The diameter of Binary Tree: " + getDiameterInBigOofN(bt.root).diameter);
    }
}
