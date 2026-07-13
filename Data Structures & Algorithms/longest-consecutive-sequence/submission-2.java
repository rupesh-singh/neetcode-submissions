class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0)
            return 0;
            
        HashSet<Integer> hs = new HashSet<Integer>();

        for(int n: nums){
            hs.add(n);
        }
        int max=1, current =0;
        for(int i=0;i<nums.length;i++){
            current =1;
            if(hs.contains(nums[i]-1)){            
                int a = nums[i]-1;
                while(hs.contains(a)){
                    current++;
                    a = a-1;
                }                
                if(max < current)
                max = current;
            }
             
        }
        return max;
    }
}
