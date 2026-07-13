class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return null;
        
        String output = strs.get(0);

        for(int i=1;i<strs.size();i++){
            output = output + "|" + strs.get(i);
        }

        System.out.println(output);
        return output;
        
    }

    public List<String> decode(String str) {
        if(str == null){
            return new ArrayList<String>();
        }
        String[] output = str.split("\\|");
        System.out.println(Arrays.toString(output));
        return Arrays.asList(output);
    }
}
