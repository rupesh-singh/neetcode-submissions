class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0)
            return false;

        int[] freq = new int[1001];
        for(int i: hand){
            freq[i]++;
        }   

        for(int i=0;i<1001;i++){
            int currVal = freq[i];
            while(currVal > 0){
                int temp = i + 1;
                freq[i]--;
                for(int j=0;j<groupSize-1;j++){
                    if(freq[temp] > 0){
                        freq[temp]--;
                        temp += 1;
                    }
                    else {
                        return false;
                    }
                }
                currVal--;
            }
        }

        return true;
    }
}
