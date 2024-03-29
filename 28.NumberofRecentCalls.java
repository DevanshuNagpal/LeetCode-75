import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current timestamp to the queue
        queue.offer(t);
        
        // Remove all timestamps that are outside the time window of 3000 milliseconds
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // Return the size of the queue which represents the number of requests within the time window
        return queue.size();
    }
}
/*

class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        if(q.size() == 0){
            q.add(t);
            return 1;
        } 
        else{
            if(t <= 3000){
                q.offer(t);
            }
            else{
                int margin = t - 3000;
                while(q.size() > 0 && q.peek() < margin){
                    q.poll();
                }
                q.add(t);
            }
            return q.size();
        }
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */



*/

public class Main {
    public static void main(String[] args) {
        // Example usage
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));    // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}
