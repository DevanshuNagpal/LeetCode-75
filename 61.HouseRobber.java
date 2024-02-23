/*
Why Dp?
- We have options to choose
- optimal(max/min)
- overlapping subproblems
*/

// Tabulation + spcae optimisation
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int rob1 = 0;
        int rob2 = 0;
        for(int num:nums){
            int temp = Math.max(num+rob1,rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}

/*********************************************************************************** */
//Tabulation
/*
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) 
            return nums[0];
        int n = nums.length;
        int[] dp = new int[101];
        Arrays.fill(dp,0);
        // dp[0] = 0;
        dp[1] = nums[0];
        for(int i =2;i<n+1;i++){
            int steal = nums[i-1] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal,skip);
        }
        return dp[n];

    }
}

*/
/*********************************************************************************** */
//recursion + memoisation

/*
class Solution {
    public int rob(int[] nums) {
        int n =nums.length;

        int[] dp = new int[101];
        Arrays.fill(dp,-1);
        return rob(nums,0,dp);
    }
    private int rob(int[] nums,int index ,int[] dp){
        if(index >= nums.length){
            return 0; 
        }
        if(dp[index] != -1 ) return dp[index];
        int steal = nums[index] + rob(nums,index+2,dp);
        int skip = rob(nums,index +1,dp);
        return dp[index] = Math.max(steal,skip);
    }
}
*/
