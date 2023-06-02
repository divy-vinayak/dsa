package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Module1 {

    static class Edge{
        int src, dest, weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        /*
        *         (5)
        * 0 -------------- 1
        *                 / \
        *                /   \
        *          (1)  /     \ (3)
        *              /       \
        *             2 ------- 3
        *             |   (1)
        *             |
        *         (2) |
        *             |
        *             4
        */

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V]; // all value = null
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        // Vertex 0
        graph[0].add(new Edge(0, 1, 5));
        // Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        // Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // Vertex 4
        graph[4].add(new Edge(4, 2, 2));


        // get neighbours of
        Scanner sc = new Scanner(System.in);

        int neighbourOf = sc.nextInt();
        if(neighbourOf > 4){
            System.out.println("Error vertex doesn't exist");
            sc.close();
            return;
        }
        for(int i = 0; i < graph[neighbourOf].size(); i++){
            Edge e = graph[neighbourOf].get(i);
            System.out.println(e.dest + ", " + e.weight);
        }
        sc.close();
    }
} 
