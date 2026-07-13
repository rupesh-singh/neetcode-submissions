class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int n){
        if(parent[n] == n)
            return n;
        
        parent[n] = findParent(parent[n]);
        return parent[n];
    }

    public boolean union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA == parentB)
            return false;
        else {
            if(size[parentA] > size[parentB]){
                parent[parentA] = parentB;
                size[parentB] = size[parentA] + size[parentB];
            }
            else {
                parent[parentB] = parentA;
                size[parentA] = size[parentA] + size[parentB];
            }
            return true;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashSet<Integer> hs = new HashSet<>();
        for(int[] i: edges){
            hs.add(i[0]);
            hs.add(i[1]);
        }

        UnionFind uf = new UnionFind(hs.size());

        for(int[] i : edges){
            if(!uf.union(i[0],i[1])){
                return new int[]{i[0],i[1]};
            }
        }

        return new int[]{};
    }
}
