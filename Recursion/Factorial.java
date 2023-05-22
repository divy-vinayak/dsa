package Recursion;

public class Factorial {

    public static float factorial(int n){
        if(n < 0){
            return 1 / factorial(-1* n);
        }
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(-5));
    }
}
