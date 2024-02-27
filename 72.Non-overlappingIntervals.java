class Solution {
    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            // if(a[1] == b[1]){
            //     return a[0] - b[0];
            // }
            return a[1] - b[1];
        });
        int res = 0;
        int prev = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < prev){
                res++;
            }
            else{
                prev = intervals[i][1];
            }
        }
        return res;
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int shift = 1 - min;// = -(min-1), better than -min, since left will become -1 for left value 1 (= 1-2), this will require extra overhead for comparisons = initialize array with
        int maxIntervalRange =  1+(1 + max - min);//including min/max & indexing from 1, in order to use right value as it is, otherwise [right-1]
        int[] rightEnds = new int[maxIntervalRange];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right]) //updating rightEnds to have more closer value towards right
                rightEnds[right] = left;
        }
        int start = 1;//i=1 corresponds to interval ending at 1 (thus start for next), this will always be the valid interval
        int count = 1;
        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {//for non-existent right index values, val will be 0, so won't be counted as valid
                count++;
                start = i;
            }
        }

        return intervals.length - count;

    }
}
