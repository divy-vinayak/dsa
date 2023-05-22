package Recursion;

public class PrintNumber {

    public static void printNoInDecOrder(int n){
        if(n == 0){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printNoInDecOrder(n-1);
    }
    public static void printNoInIncOrder(int n){
        if(n == 0){
            System.out.print(n + " ");
            return;
        }
        printNoInIncOrder(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        printNoInDecOrder(50);
        printNoInIncOrder(50);
    }    
}
