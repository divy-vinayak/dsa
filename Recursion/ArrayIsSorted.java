package Recursion;

public class ArrayIsSorted {
    public static boolean isSorted(int A[], int n){
        if(n <= 1){
            return true;
        }
        return A[n-1] >= A[n-2] && isSorted(A, n-1);
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 9, 5, 6};
        System.out.println(isSorted(A, A.length));
    }
    
}
