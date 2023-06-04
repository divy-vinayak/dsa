package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    // public static class Edge{
    //     int src, dest, wt;
    //     Edge(int src, int dest, int wt){
    //         this.src = src;
    //         this.dest = dest;
    //         this.wt = wt;
    //     }
    // }
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

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 20));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void primsForMST(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));
        ArrayList<Edge> edgesInMST = new ArrayList<>();
        int finalCost = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest] = true;
                edgesInMST.add(new Edge(curr.src, curr.dest, curr.cost));
                finalCost += curr.cost;
                for(int i = 0; i < graph[curr.dest].size(); i++){
                    Edge e = graph[curr.dest].get(i);
                    pq.add(new Edge(e.src, e.dest, e.cost));
                }
            }
        }

        System.out.println("Final cost of MST: " + finalCost);
        edgesInMST.remove(0);
        for(int i = 0; i < edgesInMST.size(); i++){
            Edge e = edgesInMST.get(i);
            System.out.println("Src: " + e.src + "\tDest: " + e.dest + "\tWeight: " + e.cost);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);
        primsForMST(graph);
    }
}
