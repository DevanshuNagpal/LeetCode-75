

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort points based on the end points
 Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // No overlap, need another arrow
                arrows++;
                end = points[i][1];
            }
            // else, the current balloon overlaps with the previous one, continue
        }

        return arrows;
    }
}




/*
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Arrays.sort(points, (a, b)->(Integer.compare(a[0], b[0])));

        int prev[] = points[0]; 
        int count = 1;
        for(int i =1;i<n;i++){
            int currStartPoint = points[i][0];
            int currEndPoint =points[i][1];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if(currStartPoint > prevEndPoint){
                //no overlap 
                count++;
                prev = points[i];

            }
            else{
                //overlap

                //overlapping region
                prev[0] = Math.max(prevStartPoint,currStartPoint);
                prev[1] = Math.min(currEndPoint,prevEndPoint);

            }
        }
        return count;
    }
}
*/
