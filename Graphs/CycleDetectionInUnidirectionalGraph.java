package Graphs;
import java.util.*;

public class CycleDetectionInUnidirectionalGraph {
    static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    /*
     *               1---->0--> 2
     *                     /\   |
     *                       \  \/
     *                         3
     */
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));
    }
    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, boolean[] inCallStack, int curr){ // O(V+E)
        visited[curr] = true;
        inCallStack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                if(hasCycleUtil(graph,visited,inCallStack,e.dest)){
                    return true;
                }
            }else{
                if(inCallStack[e.dest]) return true;
            }
        }
        inCallStack[curr] = false;
        return false;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        boolean inCallStack[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(hasCycleUtil(graph, visited, inCallStack, i)){
                    return true;
                }
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);
        System.out.println(hasCycle(graph));
    }
}   
