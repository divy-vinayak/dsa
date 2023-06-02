package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsDfs {
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
    
    static void BFS(ArrayList<Edge>[] graph){ // O(V+E) -> the bigger among v and e defines the time complexity of bfs in java
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length]; // by default false

        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }

        System.out.println();
    }
    static void dfsHelper(ArrayList<Edge>[] graph, boolean[] visited, int src){
        if(!visited[src]){
            System.out.print(src + " ");
            visited[src] = true;
            for(int i = 0; i < graph[src].size(); i++){
                int dest = graph[src].get(i).dest;
                // if(!visited[dest]){
                    dfsHelper(graph, visited, dest);
                // }
            }
        }
    }
    static void DFS(ArrayList<Edge>[] graph){ // O(V+E)
        int src = 0;
        boolean visited[] = new boolean[graph.length];
        dfsHelper(graph, visited, src);
        System.out.println();
    }

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){ // O(V+E)
        visited[src] = true;
        if(src == dest) return true;
        else{
            for(int i = 0; i < graph[src].size(); i++){
                if(!visited[graph[src].get(i).dest] && hasPath(graph, graph[src].get(i).dest, dest, visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[7];
        createGraph(graph);
        BFS(graph);
        DFS(graph);
        int src = 5;
        int dest = 8;
        System.out.print("Src: " + src + "\t Dest: " + dest);
        if(hasPath(graph, src, dest, new boolean[graph.length])){
            System.out.println(" --> EXISTS.");
        }else{
            System.out.println(" --> DOES NOT EXIST.");
        }
        
    }
}
