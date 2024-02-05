

class Solution {
    public int maxVowels(String s, int k) {
        int maxCnt =0;
        for(int i =0;i<k;i++){

            if(isVowel(s.charAt(i))){
                maxCnt++;
            }
        }
        int windowCnt = maxCnt;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                windowCnt++;
            }
            if(isVowel(s.charAt(i-k))){
                windowCnt--;
            }
            maxCnt = Math.max(maxCnt,windowCnt);
        }
        return maxCnt;
    }
    boolean isVowel(char s){
        return (s == 'a'||s == 'e'||s == 'i'||s == 'o'||s == 'u');
    }
}
