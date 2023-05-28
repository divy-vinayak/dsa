package BinarySearchTree;

public class Module2 {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static void inOrderPrintTree(Node root){
        if(root == null) return;
        inOrderPrintTree(root.left);
        System.out.print(root.data + " ");
        inOrderPrintTree(root.right);
    }
    static void preOrderPrintTree(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
    }

    static Node buildBalancedBST(int arr[], int si, int ei){
        if(si > ei) return null;
        if(si == ei) return new Node(arr[si]);
        int mi = (si+ei)/2;
        return new Node(arr[mi], buildBalancedBST(arr, si, mi-1), buildBalancedBST(arr, mi+1, ei));
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12, 13};
        Node root = buildBalancedBST(arr, 0, arr.length-1);
        inOrderPrintTree(root);
        System.out.println();
        preOrderPrintTree(root);
        System.out.println();
    }
}
