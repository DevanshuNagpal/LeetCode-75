class Solution {
    int ans = 0;

    void dfs(List<Integer>[] graph, int cur, int pre) {
        for (int n : graph[cur]) {
            if (Math.abs(n) != pre) {
                if (n > 0) {
                    ans++;
                }
                dfs(graph, Math.abs(n), cur);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(-connection[0]);
        }
        dfs(graph, 0, -1);
        return ans;
    }
}
