package Graphs;
import java.util.*;

public class KahnAlorithm {
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
    // public static void getTopologicalSortWithBfs(ArrayList<Edge>[] graph){
    //     int inDeg[] = new int[graph.length];
    //     for(int i = 0; i < graph.length; i++){
    //         for(int j = 0; j < graph[i].size(); j++){
    //             Edge e = graph[i].get(j);
    //             inDeg[e.dest]++;
    //         }
    //     }
    //     Queue<Integer> q = new LinkedList<>();
    //     for(int i = 0; i < inDeg.length; i++){
    //         if(inDeg[i] == 0){
    //             q.add(i);
    //         }
    //     }
    //     while(!q.isEmpty()){
    //         int curr = q.remove();
    //         inDeg[curr]--;
    //         System.out.print(curr + " ");
    //         for(int i = 0; i < graph[curr].size(); i++){
    //             Edge e = graph[curr].get(i);
    //             inDeg[e.dest]--;
    //         }
    //         for(int i = 0; i < inDeg.length; i++){
    //             if(inDeg[i] == 0){
    //                 q.add(i);
    //             }
    //         }
    //     }
    //     System.out.println();
    // }
    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void getTopologicalSortWithBfs(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        getTopologicalSortWithBfs(graph);
    }
}
