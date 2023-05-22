public class Array {

    public static int getLargest(int A[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }return max;
    }

    public static int binarySearch(int A[], int key){
        int start = 0, end = A.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] == key){
                return mid;
            }
            else if(A[mid] < key){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseArray(int A[]){
        int end = A.length - 1;
        int temp;
        for(int i = 0; i < end; i++){
            temp = A[i];
            A[i] = A[end];
            A[end--] = temp;
        }
    }

    public static void printArray(int A[]){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }System.out.println();
    }

    public static void pairInArray(int A[]){
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length; j++){
                System.out.print("(" + A[i] + ", " + A[j] + ")");
            }System.out.println();
        }
    }

    // Time complexity O(n^2)
    public static void maxSubArraySum(int A[]){
        int prefix[] = new int[A.length];
        prefix[0] = A[0];
        for(int i = 1; i < A.length; i++){
            prefix[i] = prefix[i-1] + A[i];
        }
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < prefix.length; i++){
            int curSum = 0;
            for(int j = i; j < prefix.length; j++){
                curSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                // System.out.println(curSum); // + ", " + maxSum);
                if(curSum > maxSum){
                    maxSum = curSum;
                }
            }
            // System.out.println();
        }

        System.out.println("The Max sum of SubArr is " + maxSum);
        
    }

    // Kadane's algorithm
    // Time complexity = O(n)
    // if all numbers in the array are negative then print the smallest -ve number
    public static void kadane(int A[]){
        boolean allNegative = true;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= 0){
                allNegative = false;
                break;
            }
        }
        if(allNegative){
            int maxNum = Integer.MIN_VALUE;
            for(int i = 0; i < A.length; i++){
                if(A[i] > maxNum) maxNum = A[i];
            }
            System.out.println("The Max sum of SubArr is " + maxNum);
            return;
        }
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < A.length; i++){
            currSum = currSum + A[i];
            if(currSum < 0) currSum = 0;
            if(currSum > maxSum) maxSum = currSum;
        }

        System.out.println("The Max sum of SubArr is " + maxSum);
    }


    // public static int max(int A[], int start, int end){
    //     int m = Integer.MIN_VALUE;
    //     for(int i = start; i <= end; i++){
    //         if(A[i] > m) m = A[i];
    //     }
    //     return m;
    // }

    public static int min(int a, int b){
        return a < b ? a : b;
    }

    public static void RainWater(int heightMap[]){
        if(heightMap.length < 3){
            System.out.println("Total trapped water: 0");
        }
        int waterTrapped = 0;
        int leftMax[] = new int[heightMap.length];
        int rightMax[] = new int[heightMap.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heightMap.length; i++){
            if(heightMap[i] > max) max = heightMap[i];
            leftMax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = heightMap.length - 1; i >= 0; i--){
            if(heightMap[i] > max) max = heightMap[i];
            rightMax[i] = max;
        }
        for(int i = 1; i < heightMap.length - 1; i++){
            // int waterLevel = min(max(heightMap, 0, i-1), max(heightMap, i+1, heightMap.length-1)) - heightMap[i];
            int waterLevel = min(leftMax[i], rightMax[i]) - heightMap[i];
            if(waterLevel > 0){
                waterTrapped += waterLevel;
            }
        }
        System.out.println("Total trapped water: " + waterTrapped);

    }
    public static void main(String[] args) {
        // int A1[] = new int[50];
        // int A2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // int A2[] = {-1, -2, 5, -9, -4};
        // int A3[] = {1, 2, 3, 4, 5, 6};

        // Trapping Rain water problem
        int heightMap[] = {4, 2, 0, 6, 3, 2, 5};

        // Scanner sc = new Scanner(System.in);
        // System.out.println(A1[0]);
        // for(int i = 0; i < 5; i++){
        //     A1[i] = sc.nextInt();
        // }
        // for(int i = 0; i < 5; i++){
        //     System.out.print(A1[i] + " ");
        // }
        // System.out.println();
        // System.out.println("The length of array is " + A1.length);
        // System.out.println("The max in A2 is " + getLargest(A2));
        // System.out.println("The minimum number is " + Integer.MIN_VALUE);
        // System.out.println(binarySearch(A2, sc.nextInt())); 
        // printArray(A2);
        // printArray(A3);
        // reverseArray(A2);
        // reverseArray(A3);
        // printArray(A2);
        // printArray(A3);
        // pairInArray(A3);
        // maxSubArraySum(A2);
        // kadane(A2);
        RainWater(heightMap);
        

    }
}
