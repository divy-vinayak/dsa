public class Functions {
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int factorial(int n){
        int product = 1;
        if (n < 0){
            System.out.println("We don't do that here.");
            return -1;
        }
        for(int i = n; i > 0; i--){
            product *= i;
        }
        return product;
    }

    public static int nCr(int n, int r){
        return factorial(n)/(factorial(r)*factorial(n-r));
    }
    public static void main(String[] args) {
        System.out.println(nCr(5, 2));
        // System.out.println(factorial(-3));

    }
}
