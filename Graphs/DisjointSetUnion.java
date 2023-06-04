package Graphs;

public class DisjointSetUnion {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    
    public static void init(){
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
    }
    
    public static int find(int i){ //O(4K) -> K is a const => O(1)
        if(par[i] == i) return i;
        // return find(par[i]);

        // Path compression optimization
        return par[i] = find(par[i]);
    }

    public static int union(int u, int v){ //O(1)
        int parU = find(u);
        int parV = find(v);
        if(rank[parU] == rank[parV]){
            par[parV] = parU;
            rank[parU]++;
        }
        else if(rank[parU] < rank[parV]){
            par[parU] = parV;
        }
        else{
            par[parV] = parU;
        }
        return find(parU);
    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
