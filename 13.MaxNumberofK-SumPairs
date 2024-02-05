class Solution {
    public int maxOperations(int[] nums, int k) {
        int left = 0;
        int cnt = 0;
        int fl = 0;
        // Filter and store elements less than k in the original array
        for(int num : nums){
            if(num <k){
                nums[fl++] = num;
            }
        }
        int right = fl-1;
        Arrays.sort(nums,0,fl);
        while(left < right){
            if(nums[left] + nums[right] == k){
                cnt++;
                left++;
                right--;
            } 
            else if(nums[left] + nums[right] > k){
                right--;
            }
            else{
                left++;
            }
        }
        return cnt;
    }
}



/* Using Hashmap

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i<nums.length ; i++){
            int diff = k - nums[i];
            if(mp.containsKey(diff)){
                cnt++;
                if(mp.get(diff) == 1){
                    mp.remove(diff);
                }else{
                mp.put(diff,mp.get(diff) - 1);
            }
            }
            
            else{
                mp.put(nums[i] , mp.getOrDefault(nums[i],0)+ 1);
            }
        } 
        return cnt;

    }
}
*/
