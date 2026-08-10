class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int min = 1;
        int max = Integer.MIN_VALUE;

        for(int i : piles){
            max = Math.max(max,i);
        }
        //System.out.println(min+" "+max);
        int left = min, right = max;

        while(left < right){
            int mid = (left + right) / 2;
            System.out.print(mid+" ");
            if(canEat(piles,mid,h)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;

    }

    public boolean canEat(int[] piles, int mid, int h){
        int count =0;
        for(int i=0;i<piles.length;i++){
            
            if(piles[i]< mid){
                count = count + 1;
            }
            else {
                int curr = piles[i]/mid;
                int reminder = piles[i] % mid;
                count = count + ((reminder > 0) ? (curr + 1) : curr);
            }

            if(count > h){
                System.out.println("false");
                return false;
            }
        }   
        System.out.println("True");
        return true;
    }
}
