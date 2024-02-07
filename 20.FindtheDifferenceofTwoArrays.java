// class Solution {
//     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//         List<List<Integer>> ans = new ArrayList<>();
//         HashMap<Integer,Integer> map1 =  new HashMap<>();
        
//         for(int num:nums1){
//             map1.put(num,0);
//         }
//         for(int num2:nums2){
//             if(!map1.containsKey(num2)){
//                 map1.put(num2,1);

//             }
//             else if(map1.containsKey(num2) && map1.get(num2) == 0){
//                 map1.put(num2,99);
//             }
//         }
//         ans.add(map1.entrySet().stream().filter(e -> e.getValue().equals(0)).map(Map.Entry::getKey).collect(Collectors.toList()));
//         ans.add(map1.entrySet().stream().filter(e -> e.getValue().equals(1)).map(Map.Entry::getKey).collect(Collectors.toList()));
//         return ans;

//     }
// }
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] map1 = new boolean[2001];
        boolean[] map2 = new boolean[2001];
        for(int num: nums1) {
            map1[num+1000] = true;
        }
        for(int num: nums2) {
            map2[num+1000] = true;
        }
        List<Integer> ans1 = new ArrayList<>(), ans2 = new ArrayList<>();
        for(int i = 0; i < 2001; i++) {
            if(map1[i] && !map2[i]) {
                ans1.add(i-1000);
            } else if(!map1[i] && map2[i]) {
                ans2.add(i-1000);
            }
        }
        return List.of(ans1, ans2);
    }
}
