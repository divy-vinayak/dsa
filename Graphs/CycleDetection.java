package Graphs;
import java.util.*;
public class CycleDetection {
    static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    /*
     *           1-------3
     *          /        |\
     *         0         | 5----6
     *          \        |/
     *           2-------4
     */
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    public static boolean hasCycleWithDFSUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest]){
                if(e.dest == par){
                    continue;
                }else{
                    return true;
                }
            }else{
                if(hasCycleWithDFSUtil(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasCycleWithDFS(ArrayList<Edge>[] graph){ // O(V+E)
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]) {
                if(hasCycleWithDFSUtil(graph, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph1 = new ArrayList[7];
        createGraph(graph1);
        System.out.println(hasCycleWithDFS(graph1));

    }
}
