class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair<>(new Pair<>(i, j), 0));
                    vis[i][j] = 2; // Mark as visited (rotten)
                } else if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> cell = q.poll();
            int r = cell.getKey().getKey();
            int c = cell.getKey().getValue();
            int t = cell.getValue();

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair<>(new Pair<>(nrow, ncol), t + 1));
                    vis[nrow][ncol] = 2;
                    cntFresh--;
                }
            }
        }

        return cntFresh == 0 ? tm : -1;
    }
}
