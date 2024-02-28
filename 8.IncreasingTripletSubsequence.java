class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int ele : nums){
            if(ele <=first){
                first= ele;
            }
            else if(ele <= second){
                second = ele;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
