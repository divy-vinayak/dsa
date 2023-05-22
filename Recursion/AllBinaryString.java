package Recursion;


// wrong solution
public class AllBinaryString {
    public static int allBinaryStringWithNoConsOne(int n){
        if(n == 1) return 2;
        if(n <= 0) return 0;
        return 2 * allBinaryStringWithNoConsOne(n-1) + allBinaryStringWithNoConsOne(n-3);
    }

    public static void main(String[] args) {
        System.out.println(allBinaryStringWithNoConsOne(3));
    }
}
