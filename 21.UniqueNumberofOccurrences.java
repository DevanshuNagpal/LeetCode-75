class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : arr) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> freqToNum = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
            if (freqToNum.containsKey(entry.getValue())) {
                return false;
            }
            freqToNum.put(entry.getValue(), entry.getKey());
        }
        return true;
    }
}

/*
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num : arr){
            mp.put(num,mp.getOrDefault(num,0) + 1);
        }
        var set = new HashSet<>();
        for(var val: mp.values()){
            if(set.contains(val)) return false;
            else set.add(val);
        }
        return true;
    }
}
*/
