class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        if(digits.length() == 0) return ans;
        int index = 0;
        String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(index,digits,mapping,ans,output);
        return ans;
    }
    public void solve(int index,String digits , String[] mapping ,List<String> ans , StringBuilder output){
        //base case
        if(index >=  digits.length()){
            ans.add(output.toString());
            return ;
        }
        //get current digit
        int digit = digits.charAt(index)-'0';
        String value  = mapping[digit];
        //iterate over the characters corresponding to digit
        for(int i =0;i< value.length();i++){
            char ch = value.charAt(i);
            output.append(ch);
            //recursive call to the next index
            solve(index + 1,digits, mapping, ans,output);
            //backtrack
            output.deleteCharAt(output.length() - 1);
        }

    }
}
