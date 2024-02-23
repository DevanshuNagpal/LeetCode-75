class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        dp[m][n-1] = 1;
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
/*
//Memoisation

class Solution {
    public int uniquePaths(int m, int n) {
        return paths(0,0,m ,  n , new HashMap<>());
    }
    private int paths(int r , int c ,int m , int n, HashMap<List<Integer> , Integer> memo){
        if(r == m || c == n){
            return 0;

        }
        if(r == m-1 && c == n-1){
            return 1;
        }
        List<Integer> pos = List.of(r,c);
        if(memo.containsKey(pos)){
            return memo.get(pos);
        }
        int result = paths(r+1,c,m,n,memo) + paths(r,c+1,m,n,memo);
        memo.put(pos,result);
        return result;
    }
}



*/
