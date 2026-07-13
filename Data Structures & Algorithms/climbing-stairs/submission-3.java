class Solution {
    public int climbStairs(int n) {
        return recur(n);
    }

    public int recur(int n){
        if(n == 0)
         return 1;
        
        if(n < 0)
            return 0;

        return recur(n-1) + recur(n-2);
    }
}


/*
n 



*/