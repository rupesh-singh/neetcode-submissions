class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] index = new int[26];
        Arrays.fill(index,-1);
        List<Integer> output = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(index[s.charAt(i) - 'a'] == -1)
            index[s.charAt(i) - 'a'] = i;
        }

        int start =0, end = 0;
        for(int i=0;i<n;i++){
            end = Math.max(end,index[s.charAt(i) - 'a']);

            if(i == end){
                output.add(end - start + 1);
                start = i + 1;
                end = 0;
            }
        }

        return output;
    }
}


