class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int mid = 0;
        while(start < end){
            mid = start + (end - start)/2;

            if(nums[start] > nums[mid]){
                end = mid;
            }
            else if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else {
                break;
            }
        }

        return nums[start];
    }
}
