public class Sorting {

    public static void printArray(int A[]){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }System.out.println();
    }

    public static void bubbleSort(int A[]){
        for(int i = 0; i < A.length - 1; i++){
            int swap = 0;
            for(int j = 0; j < A.length - 1 - i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    swap++;
                }
                printArray(A);
            }
            if(swap == 0){
                return;
            }
        }
        // for(int i = 0; i < A.length - 1; i++){
        //     for(int j = i+1; j < A.length; j++){
        //         if(A[i] > A[j]){
        //             int temp = A[i];
        //             A[i] = A[j];
        //             A[j] = temp;
        //         }printArray(A);
        //     }
        // }
    }

    public static void selectionSort(int arr[]){
        for(int i = 0; i < arr.length - 1; i++){
            // int min = arr[i];
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    

    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            largest = Math.max(largest, arr[i]);
        } 

        int count[] = new int[largest + 1];
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        int j = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int A[] = {5, 2, 3, 6, 1, 7};
        printArray(A);
        // bubbleSort(A);
        // selectionSort(A);
        // insertionSort(A);
        // Arrays.sort(A, 1, 5);
        
        // sort in reverse
        // Arrays.sort(A, Collections.reverseOrder());

        countingSort(A);
        printArray(A);
    }
}
