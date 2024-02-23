class Solution {
    int m = (int) Math.pow(10, 9) + 7;

    public int numTilings(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[1001];
        Arrays.fill(dp, 0);
        // dp[0] = 0;
        dp[1] = 1; // For n = 1, there is only one way to tile: | or _
        dp[2] = 2; // For n = 2, there are two ways to tile: || or __
        dp[3] = 5; // For n = 3, there are five ways to tile: |||, |_|, _|_, |__, __|

        // For n >= 4, the number of ways to tile is calculated using the formula:
        // dp[i] = (2 * dp[i-1] + dp[i-3]) % m
        // Explanation:
        // - To place a vertical tile in column i, there are 2 choices:
        //   1. Place a single vertical tile '|', then the remaining area can be filled in dp[i-1] ways.
        //   2. Place two vertical tiles '||', then the remaining area can be filled in dp[i-2] ways, but since we already placed two tiles, it's equivalent to dp[i-2] = dp[i-1].
        // - To place a horizontal tile in column i, there is only 1 choice:
        //   1. Place a single horizontal tile '_', then the remaining area can be filled in dp[i-3] ways.
        // - Since we're dealing with modular arithmetic, we take the result modulo m to avoid overflow.

        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % m + dp[i - 3] % m) % m;
        }

        return dp[n];
    }
}



/*
// Memoisation


class Solution {
    // int m = 1000000007;
    int m= (int)Math.pow(10 , 9) + 7;
    public int numTilings(int n) {
        int[] dp = new int[1001];
        Arrays.fill(dp,-1);
        return solve(n,dp);

    }
    private int solve(int n,int[] dp){
        if(n == 1|| n==2) return n;
        if(n == 3 ) return 5;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (2* solve(n-1,dp) %m + solve(n-3,dp) %m)%m;
    }
}

*/
