class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
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

    public void union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(size[parentA] > size[parentB]){
            parent[parentB] = parentA;
            size[parentA] = size[parentB] + size[parentA];
        }
        else{

            parent[parentA] = parentB;
            size[parentB] = size[parentB] + size[parentA];

        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] node: edges){
            uf.union(node[0],node[1]);
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(uf.findParent(i));
        }

        return hs.size();


    }
}
