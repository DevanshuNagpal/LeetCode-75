class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int start =1;
        solve(start,k,n,ans,new ArrayList<>());
        return ans;
    }
    void solve(int start,int k , int target,List<List<Integer>> ans , ArrayList<Integer> currList ){
        
        if(currList.size() ==k){
            if(target == 0) ans.add(new ArrayList<>(currList));
            return ;    
        }
        for(int i = start;i<10;i++){
            if(target - i >=0)
            {
                currList.add(i);
                solve(i + 1,k,target - i,ans,currList);
                //backtrack
                currList.remove(currList.size() - 1);
                
            }
            else break;

        }
        
    }
}
