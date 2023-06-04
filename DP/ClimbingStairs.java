package DP;

public class ClimbingStairs {
    // static int possibleWays(int n){
    //     if(n == 0 || n == 1){
    //         return 1;
    //     }
    //     return possibleWays(n-1) + possibleWays(n-2);
    // }
    static int helper(int n, int[] possibleWaysArr){
        if(n < 0) return 0;
        if(n == 0 || n == 1){
            return 1;
        }
        if(possibleWaysArr[n] != 0){
            // System.out.println("memoa");
            return possibleWaysArr[n];
        }
        return possibleWaysArr[n] = helper(n-1, possibleWaysArr) + helper(n-2, possibleWaysArr);
    }
    static int possibleWays(int n){
        int possibleWaysArr[] = new int[n+1];
        return helper(n, possibleWaysArr);
    }
    public static void main(String[] args) {
        int n = 20;
        System.out.println(possibleWays(n));
    }
}
