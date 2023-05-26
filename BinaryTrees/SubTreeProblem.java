package BinaryTrees;

public class SubTreeProblem {
    static class Node {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static boolean areSame(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null || root2 == null)){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return areSame(root1.left, root2.left) && areSame(root1.right, root2.right);
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null) return false;
        if(root.data == subRoot.data){
            return areSame(root, subRoot);
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(areSame(root, subRoot));
        System.out.println(isSubtree(root, subRoot));


    }
}
