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
    static void preOrderPrintTree(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
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
    static boolean hasKey(Node root, int key){
        if(root == null) return false;
        if(root.data == key) return true;
        return key > root.data ? hasKey(root.right, key): hasKey(root.left, key);
    }
    public static boolean validateBSTInner(Node root, int min, int max){
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return validateBSTInner(root.left, min, root.data) && validateBSTInner(root.right, root.data, max);
    }
    public static boolean validateBST(Node root){
        return validateBSTInner(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void mirrorBST(Node root){
        if(root == null) return;
        mirrorBST(root.left);
        mirrorBST(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static void main(String[] args) {
        // int arr[] = {5, 1, 3, 4, 2, 7};
        int arr[] = {8, 5, 3, 6, 10, 11};
        Node root = BuildBST(arr);
        inOrderPrintTree(root);
        System.out.println();
        System.out.println(validateBST(root));
        
        mirrorBST(root);
        inOrderPrintTree(root);
        System.out.println();
        System.out.println(validateBST(root));
    }
}
