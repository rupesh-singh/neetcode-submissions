class Solution {
    public String foreignDictionary(String[] words) {
      // adj list
      List<List<Integer>> adj = new ArrayList<>();
      // hashset 
      HashSet<Character> hs = new HashSet<>();

      for(int i=0;i<26;i++){
        adj.add(new ArrayList<>());
      }

      for(String s : words){
        for(char c: s.toCharArray()){
            hs.add(c);
        }
      }

      for(int i=0;i<words.length-1;i++){
        String s1 = words[i];
        String s2 = words[i+1];

        int n = Math.min(s1.length(),s2.length());
        int flag = 0;
        for(int j=0;j<n;j++){
            if(s1.charAt(j) != s2.charAt(j)){
                flag = 1;
                adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                break;
            }            
        }

        if(flag ==0 && s1.length() > s2.length()){
            return "";
        }
      }

      int[] out = topoSort(adj,hs);
      String output = "";
      for(int i: out){
        output = output + (char)(i + (int)'a');
      }
      return output;

    }

    public int[] topoSort(List<List<Integer>> adj, HashSet<Character> hs){
        int n = hs.size();
        int[] ans = new int[n];
        int[] indegree = new int[26];
        Queue<Integer> q = new LinkedList<>();

        for(List<Integer> a: adj){
            for(int s: a){
                indegree[s]++;
            }
        }
        
        for(int i=0;i<adj.size();i++){
            if(indegree[i] == 0 && hs.contains((char)(i+'a'))){
                q.add(i);
            }
        }

        int count =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[count++] = curr;

            for(int i : adj.get(curr)){
                indegree[i]--;
                if(indegree[i] == 0)
                    q.add(i);
            }
        }

        return count == n ? ans : new int[0];

    }
}
