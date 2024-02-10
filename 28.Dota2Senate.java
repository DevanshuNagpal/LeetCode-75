import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        // Initialize queues for senators from both parties
        Queue<Integer> D = new LinkedList<>(); // Queue for senators from the 'D' party (Dire)
        Queue<Integer> R = new LinkedList<>(); // Queue for senators from the 'R' party (Radiant)
        
        // Populate the queues based on the input string 'senate'
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                R.offer(i); // Add the index of the 'R' senator to the 'R' queue
            } else {
                D.offer(i); // Add the index of the 'D' senator to the 'D' queue
            }
        }

        // While both queues are not empty, simulate the process of banning senators
        while (!D.isEmpty() && !R.isEmpty()) {
            int rTurn = R.poll(); // Retrieve the index of the next 'R' senator
            int dTurn = D.poll(); // Retrieve the index of the next 'D' senator

            // Compare the indices of the next 'R' and 'D' senators
            // The senator with the smaller index bans the other senator
            if (rTurn < dTurn) {
                R.offer(rTurn + senate.length()); // Re-add the 'R' senator with an updated index (simulate banning)
            } else {
                D.offer(dTurn + senate.length()); // Re-add the 'D' senator with an updated index (simulate banning)
            }
        }

        // Determine the winner based on the remaining senators in the queues
        if (!D.isEmpty()) {
            return "Dire"; // Return "Dire" if there are remaining 'D' senators
        } else {
            return "Radiant"; // Return "Radiant" if there are remaining 'R' senators
        }
    }
}



/*

class Solution {
    // Entry point method to predict the victory based on the senate string
    public String predictPartyVictory(String senate) {
        // Convert the input string to a character array and call the 'vote' method with initial vote count 0
        return vote(senate.toCharArray(), 0);
    }

    // Recursive method to simulate the voting process
    private String vote(char[] charArray, int votes) {
        // Initialize counters for remaining 'R' and 'D' senators
        int r = 0;
        int d = 0;

        // Iterate through the character array representing the senate
        for (int i = 0; i < charArray.length; i++) {
            // Process each senator
            if (charArray[i] == 'R') {
                // If it's an 'R' senator and votes are in favor of Radiant, increment 'R' counter
                if (votes >= 0) {
                    r++;
                } else {
                    // If votes are in favor of Dire, invalidate the vote by marking senator as '#'
                    charArray[i] = '#';
                }
                // Update the vote count
                votes++;
            } else if (charArray[i] == 'D') {
                // If it's a 'D' senator and votes are in favor of Dire, increment 'D' counter
                if (votes <= 0) {
                    d++;
                } else {
                    // If votes are in favor of Radiant, invalidate the vote by marking senator as '#'
                    charArray[i] = '#';
                }
                // Update the vote count
                votes--;
            }
        }

        // Check if either party has no remaining senators
        if (r == 0) {
            return "Dire"; // If 'R' senators are depleted, Dire wins
        }
        if (d == 0) {
            return "Radiant"; // If 'D' senators are depleted, Radiant wins
        }

        // If both parties still have senators remaining, recursively call 'vote' method with updated parameters
        return vote(charArray, votes);
    }
}

*/
