class Solution {
    public int compress(char[] chars) {
        StringBuilder str  = new StringBuilder();
        int cnt = 1;
        char prev =chars[0] ;
        for(int i =1;i<chars.length;i++){
            
            if (chars[i] == prev){
                cnt++;
            }
            else{
                str.append(prev);
                if (cnt > 1) {
                    str.append(cnt);
                }
                cnt = 1;
                prev = chars[i];
            }
            
        }
        str.append(prev);
        if (cnt > 1) {
            str.append(cnt);
        }
        char[] ans = str.toString().toCharArray();
        for(int i=0;i<ans.length;i++){
            chars[i]= ans[i];
        }
        return ans.length;
    }
}
