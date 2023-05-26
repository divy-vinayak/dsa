package BinaryTrees;

public class Module3 {
    public static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void helper(Node root, int level, int currLevel){
        if(root == null) return;
        if(currLevel == level){
            System.out.print(root.data + " ");
            return;
        }
        helper(root.left, level, currLevel+1);
        helper(root.right, level, currLevel+1);
    }
    public static void printLevel(Node root, int level){
        helper(root, level, 1);
        System.out.println();
    }
    public static void main(String[] args) {
        /*
         *               1
         *             /   \
         *            2     3
         *           / \   / \
         *          4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printLevel(root, 3);

    }
}
