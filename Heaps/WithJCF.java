package Heaps;
import java.util.*;
public class WithJCF {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            // if(this.rank < s2.rank) return -1;
            // if(this.rank == s2.rank) return 0;
            // return 1;

            return this.rank - s2.rank;
        }

        void print(){
            System.out.println("Rank: " + this.rank + "\tName: " + this.name);
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq =  new PriorityQueue<>();
        // pq.add(5);
        // pq.add(9);
        // pq.add(4);
        // pq.add(2);

        
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Divy", 1));
        pq.add(new Student("Pratyush", 3));
        pq.add(new Student("Ayush", 6));
        pq.add(new Student("Purva", 4));
        
        while(!pq.isEmpty()){
            pq.remove().print();
        }System.out.println();
    }
}
