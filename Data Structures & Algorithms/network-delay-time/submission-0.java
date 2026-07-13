class Node {
    int n;
    int t;
    public Node(int n, int t){
        this.n = n;
        this.t = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }   

        for(int[] i : times){
            adj.get(i[0] - 1).add(new Node(i[1],i[2]));
        }

        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] time = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k -1] = 0;
        q.add(new int[]{k,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(Node i: adj.get(curr[0] - 1)){
                if(time[i.n - 1] > curr[1] + i.t ){
                    time[i.n - 1] = curr[1] + i.t;
                    q.add(new int[]{i.n,curr[1] + i.t});
                }
            }
        }
        int ans = 0;
        for(int t : time){
            if(t == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
