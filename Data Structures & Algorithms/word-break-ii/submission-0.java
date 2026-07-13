class Solution {
    List<String> output = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // for O(1) access
        HashSet<String> hs = new HashSet<>();
        for(String temp: wordDict){
            hs.add(temp);
        }

        wb(s,hs, new ArrayList<String>(), 0);
        return output;
    }

    public void wb(String s, HashSet<String> dict, List<String> list, int index){
        if(index >= s.length()){
            String result = String.join(" ", list);
            output.add(result);
        }

        for(int i=index;i<s.length();i++){
            String sub = s.substring(index, i+1);
            if(dict.contains(sub)){
                list.add(sub);
                wb(s,dict,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}