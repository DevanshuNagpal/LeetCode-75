// Tabulation + O(1) space
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if(n<=2) return Math.min(first,second);
        for(int i = 2;i<n;i++){
            int curr = cost[i] + Math.min(first,second);
            first = second;
            second = curr;
        }
        return Math.min(first,second);
    }
}


/* Bottom up Tabulation 

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i =0;i<n;i++){
            if(i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
*/


/* TLE - Memoisation
class Solution {
        // Top Down Memoization - O(n) 1ms
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    private int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n==0 || n==1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
        return dp[n];
}       
}
*/
