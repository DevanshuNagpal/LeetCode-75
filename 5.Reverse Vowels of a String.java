class Solution {
    public String reverseVowels(String s) {
        // StringBuilder str = new StringBuilder();
        int l = 0;
        int r = s.length() - 1;
        char[] ch = s.toCharArray();
            
        while(l<=r){
            if( isVowel(ch[l]) && isVowel(ch[r])){
                swap(ch,l,r);
                l++;
                r--;
            }
            else if( isVowel(ch[l]) && !isVowel(ch[r])){
                r--;
            }
            else{l++;}
            
            
        }
        // for(char ele : ch){
        //     str.append(ele);
        // }
        // return str.toString();
        String answer = new String(ch);
        return answer;
        
    }

    public void swap(char[] ch, int l, int r) {
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
    }
        public boolean isVowel(char ch){
            return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
        }
}



