class Pair {
    int first;
    int second;
    int time;

    public Pair(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> pq = new LinkedList<>();
        int rows = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[rows][col];
        int freshcount = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = grid[i][j];
                    pq.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    freshcount++;
                }
            }
        }

        int count = 0;
        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};
        int maxt = 0;
        while(!pq.isEmpty()){
            Pair p = pq.peek();

            for(int i=0;i<4;i++){
                int nrow = p.first + r[i];
                int ncol = p.second + c[i];

                if(nrow >= 0 && nrow<rows && ncol>=0 && ncol<col){
                    if(grid[nrow][ncol] == 1 && visited[nrow][ncol] != 2){
                        pq.add(new Pair(nrow,ncol,p.time + 1));
                        visited[nrow][ncol] = 2;
                        count++;
                    }
                }

            }

            pq.poll();
            
                if(maxt < p.time){
                    maxt = p.time;
                }

        }

        return (count == freshcount) ? maxt : -1;
    }
}
