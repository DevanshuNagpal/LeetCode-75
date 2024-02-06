class Solution {
    public int longestSubarray(int[] nums) {
        int back = 0, count = 0,max = 0;
        for(int i : nums){
            if(i == 1)count++;
            else{
                max = Math.max(max,back + count);
                back = count ;
                count =0;


            }

        }
        max = Math.max(max,back + count);
        if(max == nums.length) return nums.length - 1;
        return max;
    }
}
