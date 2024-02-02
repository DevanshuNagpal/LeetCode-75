class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int i=0;
        while(i < arr.length && n != 0 ){
            
            if(arr[i] == 0 && (i == 0|| arr[i-1] == 0 ) && (i == arr.length-1 || arr[i+1] == 0)){
                n -=1;
                arr[i] = 1;
                i+=2;
            }
            else i++;
        }
        if(n == 0){
            return true;
        }
        else return false;
    }
}


