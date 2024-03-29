class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i : nums){
            totalSum+= i;
        }
        int leftSum =0;
        for(int i =0;i<n;i++){
            if(leftSum == totalSum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        
        return -1;
    }
}
