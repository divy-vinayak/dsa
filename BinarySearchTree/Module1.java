package BinarySearchTree;

public class Module1 {
    static class Node {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    static void inOrderPrintTree(Node root){
        if(root == null) return;
        inOrderPrintTree(root.left);
        System.out.print(root.data + " ");
        inOrderPrintTree(root.right);
    }
    static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(val < root.data){
            root.left = insert(root.left, val);
        }
        if(val > root.data){
            root.right = insert(root.right, val);
        }
        return root;
    }
    static Node BuildBST(int val[]){
        Node root = null;
        for(int i = 0; i < val.length; i++){
            root = insert(root, val[i]);
        }
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {5, 1, 3, 4, 2, 7};
        Node root = BuildBST(arr);
        inOrderPrintTree(root);
        System.out.println();
    }
}
