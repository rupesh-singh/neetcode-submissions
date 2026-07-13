class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] visited = new int[n][m];
        q.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = 1;

        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};

        int max = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == n -1 && curr[1] == m-1){
                max = Math.min(curr[2],max);
            }
            for(int i=0;i<4;i++){
                int r = row[i] + curr[0];
                int c = col[i] + curr[1];

                if( r >= 0 && c >=0 && r < n && c < m && visited[r][c] != 1){
                    visited[r][c] = 1;
                    int value = Math.max(curr[2],grid[r][c]);
                    q.add(new int[]{r,c,value});
                }
            }
        }

        return max;
    }
}
