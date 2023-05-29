package Heaps;

public class HeapSort {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void heapify(int arr[], int i, int size){
        int left = 2*i + 1, right =  2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx != i){
            swap(arr, i, maxIdx);
            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]){ // O(nlogn)
        // step 1 - build maxheap
        int n = arr.length;
        for(int i = arr.length/2; i >= 0; i--){
            heapify(arr, i, n);
        }
        // step 2 - push largest at the back
        for(int i = n-1; i >= 0; i--){
            // swap largest i.e. at idx = 0 with the last idx
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}
