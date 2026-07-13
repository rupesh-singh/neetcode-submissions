class Solution {
    public boolean isValidSudoku(char[][] board) {
        // first 
        int n=9,m=9;
        for(int i=0;i<n;i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=0;j<m;j++){
                if (board[i][j] == '.') continue;
                if(hs.contains(board[i][j])){
                    return false;
                }
                hs.add(board[i][j]);
            }
        }
        
        for(int i=0;i<n;i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=0;j<m;j++){
                if (board[j][i] == '.') continue;
                if(hs.contains(board[j][i])){
                    return false;
                }
                hs.add(board[j][i]);
            }
        }

        for(int s=0;s<9;s++){
            HashSet<Character> hs = new HashSet<>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int row = (s/3) * 3 + i;
                    int col = (s%3) * 3 + j;

                    if (board[row][col] == '.') continue;
                    if(hs.contains(board[row][col])){
                        return false;
                    }
                    hs.add(board[row][col]);
                }
            }
        }



        return true;

    }

}
