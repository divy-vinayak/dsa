package Graphs;
import java.util.*;
public class KruskalAlgo {
    public static class Edge implements Comparable<Edge>{
        int src, dest, cost;
        Edge(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge p2){
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph){
        /*
         *                            0
         *                           /|\
         *                          / | \
         *                         /  |  \
         *                     10 /   |30 \15
         *                       /    |    \
         *                      /     |     \
         *                     1------3------2
         *                        40     50    
         */

        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    static int par[];
    static int rank[];

    static void init(int n){
        par = new int[n];
        rank = new int[n];
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
    public static ArrayList<Edge> kruskalAlgoForMST(ArrayList<Edge> graph, int v){ // O(v + Elog(E))
        ArrayList<Edge> ans = new ArrayList<>(); 
        int finalCost = 0;
        // PriorityQueue<Edge> pq = new PriorityQueue<>();
        // System.out.println("Adding edges in queue");
        // for(int i = 0; i < graph.size(); i++){
            // Edge e = graph.get(i);
            // System.out.println("Src: " + e.src + "\tDest: " + e.dest + "\tCost: " + e.cost);
            // pq.add(e);
        // }
        // System.out.println("edges added.");
        init(v);
        Collections.sort(graph);
        for(int i = 0, count = 0; count < v-1; i++){
            // Edge e = pq.remove();
            Edge e = graph.get(i);
            if(par[e.src] != par[e.dest]){
                finalCost += e.cost;
                ans.add(e);
                union(e.src, e.dest);
                count++;
            }
        }
        
        System.out.println("Total cost: " + finalCost);
        for(int i = 0; i < ans.size();i++){
            Edge e = ans.get(i);
            System.out.println("Src: " + e.src + "\tDest: " + e.dest + "\tCost: " + e.cost);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        int v = 4;
        createGraph(graph);
        ArrayList<Edge> includedEdges = kruskalAlgoForMST(graph, v);
        System.out.println("------------------------");
        for (Edge e : includedEdges) {
            System.out.println("Src: " + e.src + "\tDest: " + e.dest + "\tCost: " + e.cost);
        }
    }
}
