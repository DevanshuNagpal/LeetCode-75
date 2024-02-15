class Solution {
    int n ;
     public void dfs(int[][] isConnected, int u, ArrayList<Boolean> visited) {
        visited.set(u, true);
        // visit n neighubours
        // find neightbours
    
        for (int v = 0 ;v<n;v++) {
            if (!visited.get(v) && isConnected[u][v] == 1) {
                dfs(isConnected, v, visited);
            }
        }
    }

     public int findCircleNum(int[][] isConnected) {
         n = isConnected.length;
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(n, false));
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                count++;

                dfs(isConnected, i, visited);
            }
        }


        return count;
    }
}
