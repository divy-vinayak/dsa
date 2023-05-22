public class AdvPatterns{
    public static void printHollowRect(int length, int width) {
        for(int i = 0; i < length; i++){
            System.out.print("* ");
        }System.out.println();
        for(int j = 0; j < width - 2; j++){
            for(int i = 0; i < length; i++){
                if (i == 0 || i == length - 1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }System.out.println();
        }
        for(int i = 0; i < length; i++){
            System.out.print("* ");
        }
    }

    public static void printInvertedTriangle(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if( i + j >= n + 1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }System.out.println();
        }
    }

    public static void invertedHalfPyramidWithNumbers(int n){
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }System.out.println();
        }
    }

    public static void printFloydsTriangle(int n){
        int a = 1;    
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(a++ + " ");
            }System.out.println();
        }
    }

    public static void printZeroOneTriangle(int n){
        boolean isOner = true;
        for(int i = 0; i < n; i++){
            boolean isOnec = isOner;
            for(int j = 0; j <= i; j++){
                if(isOnec){
                    System.out.print(1 + " ");
                    isOnec = false;
                }else{
                    System.out.print(0 + " ");
                    isOnec = true;
                }
            }
            isOner = !isOner;
            System.out.println();
        }
    }

    public static void printStar(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            for(int j = 0; j < 2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            for(int j = 0; j < 2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printSolidRhombus(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print("  ");
            }
            for(int j = 1; j <= n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    
    public static void printHollowRhombus(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print("  ");
            }
            if(i == 1 || i == n){
                for(int j = 1; j <= n; j++){
                    System.out.print("* ");
                }
            }else{
                System.out.print("* ");
                for(int j = 0; j < n-2; j++){
                    System.out.print("  ");
                }
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void printDiamond(int n){
        for(int i = 1; i <= n; i+=2){
            for(int j = 0; j < (n-i)/2; j++){
                System.out.print("  ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }System.out.println();
        }
        for(int i = n; i >= 1; i-=2){
            for(int j = 0; j < (n-i)/2; j++){
                System.out.print("  ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        // printHollowRect(50, 20);
        // printInvertedTriangle(2);
        // invertedHalfPyramidWithNumbers(5);
        // printFloydsTriangle(5);
        // printZeroOneTriangle(10);
        // printStar(13);
        // printSolidRhombus(7);
        // printHollowRhombus(5);
        printDiamond(9);
    }
}