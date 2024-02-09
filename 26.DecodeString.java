import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        // Stack to keep track of the count of repetitions
        Stack<Integer> countStack = new Stack<>();
        // Stack to keep track of the previous strings before encountering a '[' character
        Stack<StringBuilder> stringStack = new Stack<>();
        // StringBuilder to build the current string being processed
        StringBuilder currentString = new StringBuilder();
        // Variable to keep track of the count of repetitions
        int count = 0;
        
        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the count of repetitions
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                // If the character is '[', push the current count to countStack
                // Push the currentString to stringStack
                // Reset currentString and count for the inner string
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                // If the character is ']', pop the count and previous string from stacks
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // Append the currentString to the previous string 'repeatTimes' times
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                // Update currentString to the decodedString
                currentString = decodedString;
            } else {
                // If the character is a letter, append it to the currentString
                currentString.append(ch);
            }
        }
        
        // Return the final decoded string
        return currentString.toString();
    }
}
