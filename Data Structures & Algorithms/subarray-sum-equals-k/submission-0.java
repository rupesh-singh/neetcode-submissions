class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int total = 0;
        for(int i: nums){
            total = total + i;

            if(map.containsKey(total-k)){
                count = count + map.get(total-k);
            }
            map.put(total,map.getOrDefault(total,0) + 1);
        }
        return count;
    }
}