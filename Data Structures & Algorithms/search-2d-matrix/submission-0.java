class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int col = matrix[0].length;

        int start = 0, end = rows - 1 ;

        while(start <= end){
            int mid = (start + end )/2;

            if(target > matrix[mid][col - 1]){
                start = start + 1;
            }
            else if(target < matrix[mid][0]){
                end = end -1;
            }
            else {
                break;
            }
        }

        if(start > end){
            return false;
        }

        int row =(start + end) /2;
        int left= 0, right = col -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target == matrix[row][mid]){
                return true;
            }
            else if(target > matrix[row][mid]){
                left = left + 1;
            }
            else {
                right = right -1;
            }

        }
        
        return false;
    }
}
