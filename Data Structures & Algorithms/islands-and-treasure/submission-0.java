class Solution {
    public void islandsAndTreasure(int[][] grid) {
       int n=grid.length;
       int m = grid[0].length;
       Queue<int[]> q = new LinkedList<>();
       int[][] visited = new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j] == 0){
                q.add(new int[]{i,j,0});
                visited[i][j] = 1;
            }
        }
       }

       int[] r = {-1,0,1,0};
       int[] c = {0,1,0,-1};
       while(!q.isEmpty()){
        int[] curr = q.poll();

        for(int i=0;i<4;i++){
            int row = r[i] + curr[0];
            int col = c[i] + curr[1];
            if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == -1 || visited[row][col] == 1){
                continue;
            }
            else {
                grid[row][col] = 1 + curr[2];
                visited[row][col] = 1;
                q.add(new int[]{row,col,grid[row][col]});
            }
        }
       }

    }
}
