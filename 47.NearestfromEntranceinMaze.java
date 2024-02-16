import javafx.util.Pair;

import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> current = queue.poll();
                int i = current.getKey();
                int j = current.getValue();

                // Check if exit is found and not the entrance
                if ((i != entrance[0] || j != entrance[1]) &&
                        (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    return steps;
                }

                // Explore neighbors
                for (int[] dir : directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];
                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && maze[new_i][new_j] != '+') {
                        queue.offer(new Pair<>(new_i, new_j));
                        maze[new_i][new_j] = '+'; // Mark visited
                    }
                }
            }
            steps++;
        }
        return -1; // No exit found
    }
}
