package Graphs;
import java.util.*;

public class Bipartite {
    static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph1(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 1));
    }
    static void createGraph2(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 4, 1));
        graph[0].add(new Edge(0, 1, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 3, 1));


    }
    public static boolean isBiPartite(ArrayList<Edge>[] graph){ // O(V+E)
        int color[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1){
                            color[e.dest] = color[curr] == 0 ? 1: 0;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph1 = new ArrayList[4];
        ArrayList<Edge>[] graph2 = new ArrayList[5];
        createGraph1(graph1);
        createGraph2(graph2);

        System.out.println(isBiPartite(graph1));
        System.out.println(isBiPartite(graph2));
    }
}
