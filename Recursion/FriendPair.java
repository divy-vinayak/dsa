package Recursion;

public class FriendPair {

    public static int noOfPair(int n){
        if(n == 1 | n == 2){
            return n;
        }
        return noOfPair(n-1) + (n-1)*noOfPair(n-2);
    }
    public static void main(String[] args) {
        System.out.println(noOfPair(5));
    }
}
