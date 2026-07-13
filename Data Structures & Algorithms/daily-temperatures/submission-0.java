class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int curr = temperatures[i];
            int count =0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j]> curr){
                    result[i] = count + 1; 
                    break;
                }
                count++;
            }
        }

        return result;
    }
}
