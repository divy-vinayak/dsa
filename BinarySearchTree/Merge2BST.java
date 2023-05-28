package BinarySearchTree;

import java.util.ArrayList;

public class Merge2BST {
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
        if(root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
    }
    public static void inOrderSequence(Node root, ArrayList<Integer> seq){
        if(root == null) return;
        inOrderSequence(root.left, seq);
        seq.add(root.data);
        inOrderSequence(root.right, seq);
    }
    public static void sortedMerge(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3){
        int i = 0, j = 0;
        while(i < arr1.size() && j < arr2.size()){
            arr3.add(arr1.get(i) < arr2.get(j)? arr1.get(i++): arr2.get(j++));
        }
        while(i < arr1.size()) arr3.add(arr1.get(i++));
        while(j < arr2.size()) arr3.add(arr2.get(j++));
    }
    static Node buildBalancedBST(ArrayList<Integer> arr, int si, int ei){
        if(si > ei) return null;
        if(si == ei) return new Node(arr.get(si));
        int mi = (si+ei)/2;
        return new Node(arr.get(mi), buildBalancedBST(arr, si, mi-1), buildBalancedBST(arr, mi+1, ei));
    }
    public static Node mergeBSTs(Node bst1, Node bst2){
        ArrayList<Integer> seq1 = new ArrayList<>();
        ArrayList<Integer> seq2 = new ArrayList<>();
        inOrderSequence(bst1, seq1);
        inOrderSequence(bst2, seq2);
        ArrayList<Integer> mergedSeq = new ArrayList<>();
        sortedMerge(seq1, seq2, mergedSeq);

        return buildBalancedBST(mergedSeq, 0, mergedSeq.size()-1);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root3 = mergeBSTs(root1, root2);

        inOrderPrintTree(root3);
        System.out.println();
        preOrderPrintTree(root3);
        System.out.println();
    }
}
