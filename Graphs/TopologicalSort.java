package Graphs;
import java.util.*;
public class TopologicalSort {
    static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    /*
     *   5----->0<----4
     *   |            |
     *  \/            \/
     *   2---->3----->1
     */
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        graph[2].add(new Edge(2, 3, 0));
        
        graph[3].add(new Edge(3, 1, 0));
        
        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 0, 0));
        
    }
    public static void getTopologicalOrder(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> s, int curr){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[e.dest] = true;
                getTopologicalOrder(graph, visited, s, e.dest);
            }
        }
        s.push(curr);
    }
    public static void topologicalOrder(ArrayList<Edge>[] graph){
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                getTopologicalOrder(graph, visited, s, i);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        topologicalOrder(graph);
    }
}
