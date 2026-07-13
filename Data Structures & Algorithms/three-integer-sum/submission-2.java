class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     Arrays.sort(nums);
     List<List<Integer>> output = new ArrayList<>();

     for(int i=0;i<nums.length;i++){
        int target = -1 * nums[i];
        int j = i+1;
        int k = nums.length-1;

        if(i > 0 && nums[i] == nums[i-1])
            continue;

        while(j < k){
            int m = nums[j] + nums[k];

            if(m == target){
                List<Integer> temp = new ArrayList<>(){};
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                output.add(temp);
                j++;k--;

                while( j < k && nums[j] == nums[j-1])
                    j++;
            }
            else if(m < target){
                j++;
            }
            else {
                k--;
            }
          
        }
     }

        return output;
    }
}
