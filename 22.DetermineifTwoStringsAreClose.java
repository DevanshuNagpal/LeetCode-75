/*\
class Solution {
    public boolean closeStrings(String word1, String word2) {
        var s1 = new HashMap<Character,Integer>();
        var s2 = new HashMap<Character,Integer>();
        if(word1.length() != word2.length()) return false;

        for(char s  : word1.toCharArray()){
            s1.put(s,s1.getOrDefault(s,0)+1);
        }
        for(char s  : word2.toCharArray()){
            s2.put(s,s2.getOrDefault(s,0)+1);
        }

        if(!(s1.keySet()).equals(s2.keySet())) return false;
        return s1.values().stream().sorted().collect(Collectors.toList()).equals(s2.values().stream().sorted().collect(Collectors.toList()));
    }
    
    
}
*/



class Solution {
    public boolean closeStrings(String word1, String word2) {
        if( word1.length() != word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : word2.toCharArray()){
            if(freq1[ch - 'a'] == 0) return false;
            freq2[ch - 'a']++;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0;i< 26;i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
