package Graphs;
import java.util.*;

public class PathsFromSrcToDest {
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
     *   |      |     |
     *  \/     \/    \/
     *   2----->3---->1
     */
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 0));

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        graph[2].add(new Edge(2, 3, 0));
        
        graph[3].add(new Edge(3, 1, 0));
        
        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 0, 0));
        
    }
    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, StringBuilder path){ // 0(V^V)
        if(src == dest){
            System.out.print(path);
            System.out.println(src);
            return;
        }
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            path.append(src);
            allPaths(graph, e.dest, dest, path);
            path.deleteCharAt(path.length()-1);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        allPaths(graph, 5, 1, new StringBuilder());
    }
}
