import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int star : asteroids) {
            if (stack.isEmpty() || star > 0) {
                stack.push(star);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(star)) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(star)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(star);
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
