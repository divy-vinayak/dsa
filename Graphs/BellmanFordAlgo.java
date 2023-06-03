package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgo{
    public static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int vertex, dist;
        Pair(int vertex, int dist){
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        // graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
        // graph[4].add(new Edge(4, 5, 5));
    }

    public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int src){ // O(E*V)
        int dist[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // Bellman ford algorithm
        for(int vert = 0; vert < graph.length-1; vert++){
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
            
        for(int i = 0; i < dist.length; i++){
            System.out.println("Dist to " + i + " from " + src + ": " + dist[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        createGraph(graph);
        int src = 0;
        bellmanFordAlgo(graph, src);
    }
}
