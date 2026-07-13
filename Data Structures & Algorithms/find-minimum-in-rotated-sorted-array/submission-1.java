class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int left =0, right = n -1;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[left] > nums[mid]){
                right = mid;
            }
            else {
                break;
            }

        }
        return nums[left];
    }
}

// 1,2,3,4,5,6
// 3,4,5,6,1,2

// 5,6,7,8,9,1,2,3,4

// 0 + 8