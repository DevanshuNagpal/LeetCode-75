import java.util.*;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    String word = null;
    PriorityQueue<String> suggestions = new PriorityQueue<>(3, Comparator.reverseOrder());
}

class Solution {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
            if (node.suggestions.size() < 3) {
                node.suggestions.offer(word);
            }
        }
        node.word = word;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            if (node != null) {
                node = node.child[ch - 'a'];
            }
            if (node == null) {
                result.add(Collections.emptyList());
            } else {
                result.add(new ArrayList<>(node.suggestions));
            }
        }
        return result;
    }
}
