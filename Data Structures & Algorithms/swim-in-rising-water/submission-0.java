class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;

        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};
        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            max = Math.max(max,curr[2]);

            if(curr[0] == n-1 && curr[1] == n-1)
                return max;
            
            for(int i=0;i<4;i++){
                int nr = r[i] + curr[0];
                int nc = c[i] + curr[1];

                if(nr >=0 && nc >=0 && nr < n && nc < n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pq.add(new int[]{nr,nc,grid[nr][nc]});
                }

            }

        }

        // dummy 
        return 0;

    }
}