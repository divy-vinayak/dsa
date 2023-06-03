package DynamicProgramming;

public class Module1 {
    public static int fib(int n, int[] fibArr){ // O(n)
        if(n == 0 || n == 1){
            return n;
        }
        if(fibArr[n] != 0){
            return fibArr[n];
        }
        // return fib(n-1, fibArr) + fib(n-2, fibArr);
        fibArr[n] = fib(n-1, fibArr) + fib(n-2, fibArr);
        return fibArr[n];
    }

    public static void main(String[] args) {
        int n = 60;
        int f[] = new int[n+1];
        System.out.println(fib(n, f));
    }
}
