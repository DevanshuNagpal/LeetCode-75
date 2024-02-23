class Solution {
    public int tribonacci(int n) {
        //take 40 bcoz of constraint ->  0 <= n <= 37
        int[] dp = new int[40]; 
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}

/*
class Solution {
    public int tribonacci(int n) {
        return tribonacci(n , new HashMap<>());
    }
    public int tribonacci(int n , HashMap<Integer,Integer> memo){
        if(n == 0){
            return 0; 
        }
        if(n==1|| n==2){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = tribonacci(n-1,memo) + tribonacci(n-2,memo) + tribonacci(n-3,memo);
        memo.put(n,result);
        return result; 
        
    }
}
*/
