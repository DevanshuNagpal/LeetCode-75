class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(n,false));
        dfs(rooms,0,visited);
        for(boolean x: visited){
            if(!x) return false;

        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int source, List<Boolean> visited){
        visited.set(source,true);
        for(int node : rooms.get(source)){
            if(!visited.get(node)){
                dfs(rooms,node, visited);
            }
        }
    }
}
