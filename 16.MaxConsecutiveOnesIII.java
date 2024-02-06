//App 1 - beats 100%
class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0;

        // Iterate through the array using the 'right' pointer
        while (right < nums.length) {
            // If the current element is 0, decrement 'k'
            if (nums[right] == 0) {
                k--;
            }

            // If 'k' becomes negative and the element at 'left' is 0, increment 'k'
            // and move the 'left' pointer to the right to maintain at most 'k' zeros
            if (k < 0 && nums[left++] == 0) {
                k++;
            }

            // Move the 'right' pointer to expand the sliding window
            right++;
        }

        // Return the length of the longest subarray with at most 'k' zeros
        return right - left;
    }
}

/*
App 2
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxConsecutiveOnes = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the current element is 0, increment the zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zeroCount exceeds k, move the left pointer to maintain at most k zeros
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum consecutive ones
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }

        return maxConsecutiveOnes;
    }
}

*/

