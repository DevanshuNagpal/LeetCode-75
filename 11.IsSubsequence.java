class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length();int l2 = t.length();
        int i =0,j=0;

        while(i<l1 && j<l2){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return (i==l1) ? true:false;

    }
}
