class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        s = s.trim();
        String[] words = s.split("\\s+");
        


        for(String word : words){
            ans.insert(0,word);
            ans.insert(0," ");
            
        }

        return ans.toString().trim();
    }

}
