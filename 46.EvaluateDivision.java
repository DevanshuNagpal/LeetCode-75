class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        HashMap<String, List<Pair<String, Double>>> adj = new HashMap<>();

        // Build the adjacency list
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0); //'a'
            String v = equations.get(i).get(1);//'b'
            double val = values[i];

            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair<>(v, val));// a/b
            adj.get(v).add(new Pair<>(u, 1.0 / val));// b/a
        }

        // Process queries
        int m = queries.size();
        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dst = query.get(1);
            result[i] = dfs(adj, src, dst, new HashSet<>(), 1.0);
        }

        return result;
    }

    private double dfs(HashMap<String, List<Pair<String, Double>>> adj, String src, String dst, HashSet<String> visited, double product) {
        if (!adj.containsKey(src) || !visited.add(src)) {
            return -1.0;
        }

        if (src.equals(dst)) {
            return product;
        }

        double ans = -1.0;
        for (Pair<String, Double> pair : adj.get(src)) {
            ans = dfs(adj, pair.getKey(), dst, visited, product * pair.getValue());
            if (ans != -1.0) {
                break;
            }
        }

        visited.remove(src);
        return ans;
    }
}
