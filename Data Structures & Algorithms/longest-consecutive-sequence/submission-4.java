class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        int max = 1;

        for(int i: nums){
            
            if(!hs.contains(i-1)){
                int curr = i+1;
                int len =1;
                while(hs.contains(curr)){
                    len++;
                    curr = curr + 1;
                }

                max = Math.max(len,max);
            }
        }
        return max;
    }
}
