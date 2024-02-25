class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;            // Initialize profit to 0
        int minPrice = prices[0];  // Initialize minPrice to the first price
        
        // Iterate over the prices starting from the second element
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];  // Current price
            
            // If the current price is less than minPrice, update minPrice
            if (price < minPrice) {
                minPrice = price;
            } 
            
            // If the current price is greater than minPrice + fee, there's a potential profit
            if (price > minPrice + fee) {
                // Calculate the profit and add it to the total profit
                profit += price - minPrice - fee;
                // Update minPrice to the current price - fee (to account for selling)
                minPrice = price - fee;
            }
        }
        
        return profit;  // Return the total profit
    }
}




/*
class Solution {
    int dp[][] = new int[50001][2];
    int FEE;

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        FEE = fee;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        boolean buy = true;
        return solve(prices, 0, n, buy);
    }

    public int solve(int[] prices, int day, int n, boolean buy) {
        if (day >= n) return 0;
        if (dp[day][buy ? 1 : 0] != -1) return dp[day][buy ? 1 : 0];
        int profit = 0;
        if (buy) {
            int take = solve(prices, day + 1, n, false) - prices[day] - FEE;
            int not_take = solve(prices, day + 1, n, true);
            profit = Math.max(take, not_take);
        } else {
            int sell = prices[day] + solve(prices, day + 1, n, true);
            int not_sell = solve(prices, day + 1, n, false);
            profit = Math.max(sell, not_sell);
        }
        return dp[day][buy ? 1 : 0] = profit;
    }
}


*/
