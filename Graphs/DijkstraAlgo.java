package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
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

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void djikstraAldo(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.vertex]){
                visited[curr.vertex] = true;
                for(int i = 0; i < graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
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
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        int src = 0;

        djikstraAldo(graph, src);
    }
}
