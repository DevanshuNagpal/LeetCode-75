class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        int n  = height.length;
        while(left < right){
            int h = Math.min(height[left] , height[right]);
            int b = right - left;
            int area = h * b;
            maxArea = Math.max(area,maxArea);
            while(left<right && height[left] <=h){
                left++;
            }
            while(left<right &&  height[right]<=h){
                right--;
            }

        }
        return maxArea;
    }
}
