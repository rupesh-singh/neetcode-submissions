class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int a: piles){
            if(a > max)
                max = a ;
        }
        int min = 1;

        while(min <= max){
            int mid = (min + max)/2;

            if(abletoeat(piles, h, mid)){
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }

        }

        return min;

    }

    public boolean abletoeat(int[] piles, int h, int k){
        int hours = 0;
        for(int a: piles){
            hours = hours + (int) Math.ceil((double) a/k);
        }

        return hours <= h;
    }
}
