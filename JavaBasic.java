import java.util.*;
public class JavaBasic{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            System.out.println("this is " + i);
        }

        sc.close();
    }
}