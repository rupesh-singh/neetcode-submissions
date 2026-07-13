class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i: matchsticks){
            sum = sum + i;
        }

        if(sum % 4 != 0)
            return false;
        int[] sides = new int[4];

        return dfs(matchsticks, sides, 0);
    }

    public boolean dfs(int[] m, int[] sides, int i){
        if (i == m.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for(int j=0;j<4;j++){
            sides[j] = sides[j] + m[i];
            if(dfs(m,sides,i+1))
                return true;
            sides[j] = sides[j] - m[i];
        }
        return false;
    }
}