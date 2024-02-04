class Solution {


    public void moveZeroes(int[] nums) {
        int i =0;int j=0;
        while(j<nums.length){
            if(nums[j] == 0){
                j++;
            }
            else{
                nums[i] =nums[j];
                i++;
                j++;
            }
        }
        //fill the remaining places with zeroes
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
    

        
    
    /*
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroIndex=0;
        for(int i =0;i<n;i++){
            if(nums[i] != 0){
                swap(nums,i,nonZeroIndex);
                nonZeroIndex++;
            }

        }

    }
    void swap(int[]nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }    
    */
}
