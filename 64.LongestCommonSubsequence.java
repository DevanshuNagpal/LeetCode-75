//Bottom up 
// t[i][j] = LCS b/w s1 of length i , s2 of length j 

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m,n;
        m = s1.length();
        n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int row = 0;row<m+1;row++){
            dp[row][0] =0;
        }
        for(int col = 0;col<n+1;col++){
            dp[0][col] =0;
        }
        for(int i =1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];

                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }

            }
        }
        return dp[m][n];

    }
}



/*

Memoisation 
TC - s1 = 2^m , s2 = 2^n
Recursion - O(2^(m+n))
Memoisation - O(mxn)

class Solution {
    int m,n;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();

        int[][] dp = new int[1001][1001];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0,dp);
    }
    private int solve(String s1, String s2, int i , int j,int[][] dp ){
        if(i >= s1.length() || j>= s2.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] =  1 + solve(s1,s2,i+1,j+1,dp);
            
        }
        
        else{
            return dp[i][j] =   Math.max(solve(s1,s2,i,j+1,dp) , solve(s1,s2,i+1,j,dp));
        }
    }
}

 */
