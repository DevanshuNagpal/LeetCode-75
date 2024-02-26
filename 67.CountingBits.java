class Solution {
    //Brian Kernighan’s Algorithm
    public int countOnes(int n){
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public int[] countBits(int n) {
       int ans[] = new int[n+1];
       for(int i =0;i<ans.length;i++){
           ans[i] = countOnes(i);

       }
       return ans;
    }
}
