
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            int[] column = new int[grid.length];
            for(int j = 0; j < grid.length; j++) column[j] = grid[j][i];
            for(int[] row : grid) {
                if(Arrays.equals(row, column)) count++;
            }
        }
        return count;
    }
}


/*
class Solution {
    public int equalPairs(int[][] grid) {
        int len = grid.length;
        int count = 0;
        Map<List<Integer>,Integer> rowMap =  new HashMap<>();
        Map<List<Integer>,Integer> colMap =  new HashMap<>();
        
        // Store rows and columns in maps
        for(int ri = 0 ; ri < len ; ri++){
            List<Integer> rowList = new ArrayList<>();
            List<Integer> colList = new ArrayList<>();
            for(int cj = 0;cj < len;cj++){
                rowList.add(grid[ri][cj]);
                colList.add(grid[cj][ri]);

            }
            rowMap.put(rowList,rowMap.getOrDefault(rowList,0)+1);
            colMap.put(colList,colMap.getOrDefault(colList,0)+1);

        }
        // Count the number of equal row and column pairs

        for(List<Integer> row :  rowMap.keySet()){
            count+= rowMap.get(row) * colMap.getOrDefault(row,0);
        }

    
        
        return count;
    }
}

*/
// class Solution {
//     public int equalPairs(int[][] grid) {
//         int len = grid.length;
//         int count = 0;

//         for (int ri = 0; ri < len; ri++) {
//             for (int cj = 0; cj < len; cj++) {
//                 boolean isEqual = true;

//                 for (int i = 0; i < len; i++) {
//                     if (grid[ri][i] != grid[i][cj]) {
//                         isEqual = false;
//                         break;
//                     }
//                 }

//                 if (isEqual) count++;
//             }
//         }

//         return count;
//     }
// }
