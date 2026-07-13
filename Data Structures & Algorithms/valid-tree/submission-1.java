class pair {
    int n;
    int p;

    public pair(int n, int p){
        this.n = n;
        this.p = p;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> hs = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] t: edges){
            adj.get(t[0]).add(t[1]);
            adj.get(t[1]).add(t[0]);
        }

        Stack<pair> st = new Stack<>();
        st.push(new pair(0,-1));
        hs.add(0);

        while(!st.isEmpty()){
            pair temp = st.pop();

            for(int l: adj.get(temp.n)){
                if(!hs.contains(l)){
                    st.push(new pair(l,temp.n));
                    hs.add(l);
                }
                else if(hs.contains(l) && temp.p != l){
                    return false;
                }
            }
        }

        return hs.size() == n ? true : false;

    }
}
