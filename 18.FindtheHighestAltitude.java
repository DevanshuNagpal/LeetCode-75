class Solution {
    public int largestAltitude(int[] gain) {
        int currentAlt = 0;
        int max = 0;
        for(int alt : gain ){
            currentAlt += alt;
            max = Math.max(max,currentAlt);
        }
        return max;
        
        
    }
}
