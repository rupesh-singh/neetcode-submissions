class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        
        int value = recur(coins,amount);
        return value >= 1e9 ? -1 : value;
    }

    public int recur(int[] coins, int amount){
        if(amount == 0)
            return 0;
        
        if(map.containsKey(amount))
            return map.get(amount);

        int count = (int) 1e9;
        for(int i: coins){
            if(amount - i >= 0){
                count = Math.min(count, 1 + recur(coins,amount - i));                
            }
        }
        map.put(amount,count);
        return count;
    }
}
