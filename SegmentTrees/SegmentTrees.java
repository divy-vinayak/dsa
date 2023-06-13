package SegmentTrees;
/*
 *         -> A full binary tree (
 *              -> Each node have 2 childs except the leaf nodes.)
 *         -> No. of nodes are 2n-1 but are taken as 4n for safety
 *         -> No. of levels are log(n)
 */
public class SegmentTrees{
    public static class SegTree{
        static int st[];
        int arr[];
        public void buildTree(int arr[]){
            st = new int[arr.length*4];
            this.arr = arr;
            buildTreeHelper(arr, 0, 0, arr.length-1);
        }
        private static void buildTreeHelper(int arr[], int curr, int si, int ei){
            if(si > ei){
                return;
            }if(si == ei){
                st[curr] = arr[si];
                return;
            }
            int mid = (si + ei)/2;
            buildTreeHelper(arr, 2*curr + 1, si, mid);
            buildTreeHelper(arr, 2*curr + 2, mid+1, ei);
            st[curr] = st[2*curr+1] + st[2*curr+2];
        }
        public void printSt(){
            for(int i = 0; i < arr.length*2 - 1; i++){
                System.out.print(st[i] + " ");
            }System.out.println();
        }
        public int getSum(int si, int ei){
            return getSumHelp(0, 0, arr.length-1, si, ei);
        }
        public static int getSumHelp(int i, int si, int sj, int qi, int qj){
            if(qj < si || qi > sj){
                return 0;
            }else if(si >= qi && sj <= qj){
                return st[i];
            }else{
                int mid = (si+sj)/2;
                return getSumHelp(2*i+1, si, mid, qi, qj) + getSumHelp(2*i+2, mid+1, sj, qi, qj);
            }
        }

        public void update(int arr[], int v, int idx){
            updateHelper(v-arr[idx], 0, idx, 0, arr.length-1);
            arr[idx] = v;
        }
        public static void updateHelper(int diff, int i, int idx, int si, int sj){
            if(idx < si || idx > sj){
                return;
            }else if(si == sj){
                st[i] += diff;
            }else{
                st[i] += diff;
                int mid = (si+sj)/2;
                updateHelper(diff, 2*i+1, idx, si, mid);
                updateHelper(diff, 2*i+2, idx, mid+1, sj);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        SegTree s = new SegTree();
        s.buildTree(arr);
        s.printSt();
        System.out.println(s.getSum(0,2));
        s.update(arr, 5, 1);
        s.printSt();
        System.out.println(s.getSum(0,2));
    }
}