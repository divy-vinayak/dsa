public class DivideAndConquer {

    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei) return;

        int midIdx = si + (ei - si)/2; // (si + ei)/2
        mergeSort(arr, si, midIdx);
        mergeSort(arr, midIdx + 1, ei);
        merge(arr, si, midIdx, ei);
    }
    
    public static void merge(int arr[], int si, int mi, int ei){
        int temp[] = new int[ei-si+1];
        int i = si, j = mi+1, k = 0;

        while(i <= mi && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mi) temp[k++] = arr[i++];
        while(j <= ei) temp[k++] = arr[j++];

        for(k = 0, i = si; k < temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei) return;
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j = si; j < ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    
    public static void printArr(int A[]){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }System.out.println();
    }
    public static void main(String[] args) {
        int A[] = {1, 3, 6, 2, 4, 5, 6, 9, 8};
        printArr(A);
        // mergeSort(A, 0, A.length-1);
        quickSort(A, 0, A.length-1);
        printArr(A);
    }
}
