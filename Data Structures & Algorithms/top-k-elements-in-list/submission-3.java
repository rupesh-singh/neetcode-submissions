class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i: nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            pq.add(entry.getKey());
        }
        while(pq.size() > k){
            pq.poll();
        }

        int[] output = new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            output[i++] = pq.poll();
        }
        return output;
    }
}
