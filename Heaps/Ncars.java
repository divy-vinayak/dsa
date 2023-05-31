package Heaps;
import java.util.PriorityQueue;

public class Ncars {
    public static class Point implements Comparable<Point>{
        int x, y, distSq;

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distSq = x*x + y*y;
        }
        void print(){
            System.out.print("{x: " + this.x + ", y: " + this.y + "} ");
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pq.add(new Point(arr[i][0], arr[i][1]));
        }

        for(int i = 0; i < k; i++){
            pq.peek().print();
            pq.remove();
        }System.out.println();
    }
}
