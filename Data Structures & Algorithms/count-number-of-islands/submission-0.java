class Solution {
    
    public void dfs(char[][] grid, int[][] visited, int row, int col, int totalrows, int totalcol){
        
        visited[row][col] = 1;

        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};

        for(int i =0;i<4;i++){
            int nrow = row + r[i];
            int ncol = col + c[i];

            if(nrow >=0 && nrow < totalrows && ncol >=0 && ncol < totalcol ){
                if(grid[nrow][ncol] == '1' && visited[nrow][ncol] != 1){
                    dfs(grid,visited,nrow,ncol,totalrows,totalcol);
                }
            }
        }

    }
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        int islands = 0;

        int[][] visited = new int[rows][col];

        for(int i=0;i<rows;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    dfs(grid,visited,i,j,rows,col);
                    islands++;
                }
            }
        }

        return islands;

    }
}
