package BinarySearchTree;

public class Module2b {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Info{
        boolean isBST;
        int max, min, size;
        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static boolean isValidBST(Node root, Info left, Info right){
        if(!left.isBST || !right.isBST) return false;
        if(root.data <= left.max || root.data >= right.min) return false;
        return true;
    }
    public static int maxSize = 0;
    public static Info sizeOfLargestBST(Node root){
        if(root == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Info left = sizeOfLargestBST(root.left);
        Info right = sizeOfLargestBST(root.right);
        Info currNode = new Info(isValidBST(root, left, right),
                                left.size + right.size + 1,
                                Math.min(root.data, Math.min(left.min, right.min)),
                                Math.max(root.data, Math.max(left.max, right.max)));
        if(currNode.isBST){
            maxSize = Math.max(maxSize, currNode.size);
        }
        return currNode;
    }
    public static void main(String[] args) {
        /*
         *           50
         *          /   \
         *        30     60
         *       / \     / \
         *      5  20   45  70
         *                  / \
         *                65   80
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        sizeOfLargestBST(root);
        System.out.println(maxSize);
    }
}
