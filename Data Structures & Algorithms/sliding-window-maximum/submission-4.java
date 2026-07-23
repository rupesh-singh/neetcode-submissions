class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> nums[b] - nums[a]);
        List<Integer> list = new ArrayList<>();
// [1,0,2]
        for(int i=0;i<nums.length;i++){
            pq.add(i);
            while(!pq.isEmpty() && pq.peek() <= i - k){
                pq.poll();
            }

            if(i >= k - 1){
                //System.out.println(nums[pq.peek()]+": "+i);
                list.add(nums[pq.peek()]);
            }
        }

        int[] output = new int[list.size()];
        for(int i=0;i<list.size();i++){
            output[i] = list.get(i);
        }
        return output;
    }
}
