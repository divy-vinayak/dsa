package DP;
public class KnapSack{

    // Recursion and Memoization
    public static int helper(int[] wt, int[] val, int cap, int curr, int[][] dp){
        if(dp[curr][cap] != -1){
            return dp[curr][cap];
        }
        if(curr >= wt.length || cap <= 0){
            return  dp[curr][cap] = 0;
        }
        if(cap < wt[curr]){
            return dp[curr][cap] = helper(wt, val, cap, curr+1, dp);
        }
        return dp[curr][cap] = Math.max(helper(wt, val, cap-wt[curr], curr+1, dp) + val[curr], helper(wt, val, cap, curr+1, dp));
    }
    public static int maxProfit(int[] wt, int[] val, int cap){
        int dp[][] = new int[wt.length+1][cap+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = helper(wt, val, cap, 0, dp);
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j] + "\t\t");
            }System.out.println();
        }
        
        return ans;
    }
    public static int maxProfitWithTabulation(int[] wt, int[] val, int W){
        int dp[][] = new int[wt.length+1][W+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                int v = val[i-1]; // val of ith item
                int w = wt[i-1];  // wt of ith item
                if(w<=j){
                    int includeProfit = v + dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print((dp[i][j]/10 == 0? "0" + dp[i][j]: dp[i][j]) + "  ");
            }System.out.println("\n");
        }
        return dp[wt.length][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int cap = 7;
        // System.out.println(maxProfit(wt, val, cap));
        System.out.println(maxProfitWithTabulation(wt, val, cap));
    }
}