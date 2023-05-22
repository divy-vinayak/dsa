import java.util.*;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        char ch = 'A';
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=i; j++){
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
