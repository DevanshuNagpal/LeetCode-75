class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int len;
        if(len1 > len2){
            len = len1;
        }
        else{
            len = len2;
        }
        // int len = Math.max(len1,len2) ;

        for(int i =0;i < len;i++){
            if(i<len1){
                str.append(word1.charAt(i));
            }
            if(i<len2)
                str.append(word2.charAt(i));
        }
        return str.toString();
    }
}
