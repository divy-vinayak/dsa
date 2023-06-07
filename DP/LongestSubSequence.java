package DP;

public class LongestSubSequence {
    public static int longestSubSequence(String s1, String s2, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + longestSubSequence(s1, s2, m-1, n-1);
        }else{
            return Math.max(longestSubSequence(s1, s2, m-1, n), longestSubSequence(s1, s2, m, n-1));
        }
    }
    public static int longestSubSequenceMemo(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return longestSubSequenceMemoHelper(s1, s2, s1.length(), s2.length(), dp);
    }
    public static int longestSubSequenceMemoHelper(String s1, String s2, int m, int n, int[][]dp){
        if(m == 0 || n == 0){
            return dp[m][n] = 0;
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            if(dp[m][n] != -1){
                return dp[m][n];
            }else{
                return dp[m][n] = 1+longestSubSequenceMemoHelper(s1, s2, m-1, n-1, dp);
            }
        }else{
            if(dp[m][n] != -1){
                return dp[m][n];
            }else{   
                return dp[m][n] = Math.max(longestSubSequenceMemoHelper(s1, s2, m-1, n, dp), longestSubSequenceMemoHelper(s1, s2, m, n-1, dp));
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "abcdefg", s2 = "acef";
        System.out.println(longestSubSequence(s1, s2, s1.length(), s2.length()));
        System.out.println(longestSubSequenceMemo(s1, s2));
    }
}
