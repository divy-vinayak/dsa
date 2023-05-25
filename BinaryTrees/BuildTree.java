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
        public static Node preOrderBuildTree(int nodes[]){
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
    }
}
