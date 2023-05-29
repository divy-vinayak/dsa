package Heaps;

import java.util.ArrayList;

public class Heaps {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public boolean isEmpty(){
            return arr.size() == 0;
        }
        public void insert(int data){
            arr.add(data);
            int childIdx = arr.size()-1;
            int parentIdx = (childIdx-1)/2;
            while(arr.get(childIdx) < arr.get(parentIdx)){
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(childIdx));
                arr.set(childIdx, temp);
                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }
        }
        private void heapify(int i){ //O(log)
            int left = 2*i +1, right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                int temp = arr.get(minIdx);
                arr.set(minIdx, arr.get(i));
                arr.set(i, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            // step 1 - swap first and last in array
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 - remove the last element from arrayList
            int val = arr.remove(arr.size()-1);

            // step 3 - heapify i.e. fix the heap
            heapify(0);
            return val;
        }
        public int peek(){
            return arr.get(0);
        }
    }
    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(4);
        myHeap.insert(5);
        myHeap.insert(2);
        myHeap.insert(6);

        while(!myHeap.isEmpty()){
            System.out.print(myHeap.peek() + " ");
            myHeap.remove();
        }System.out.println();
    }
}
