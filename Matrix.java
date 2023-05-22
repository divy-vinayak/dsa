import java.util.Scanner;

public class Matrix {
    
    public static void search(int a[][], int val){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] == val){
                    System.out.println("at: " + i + ", " + j);
                    return;
                }
            }
        }
        System.out.println("not found");
    }

    public static void spiralPrint(int arr[][]){
        int sr = 0, er = arr.length - 1, sc = 0, ec = arr[0].length - 1;

        while(sr <= er && sc <= ec){
            // top boundary
            for(int j = sc; j <= ec; j++){
                System.out.print(arr[sr][j] + " ");
            }
            for(int i = sr + 1; i <= er; i++){
                System.out.print(arr[i][ec] + " ");
            }
            for(int j = ec - 1; j >= sc; j--){
                if(sr == er){
                    return;
                }
                System.out.print(arr[er][j] + " ");
            }
            for(int i = er - 1; i > sr; i--){
                if(sc == ec){
                    return;
                }
                System.out.print(arr[i][sc] + " ");
            }
            sr++;
            er--;
            sc++;
            ec--;
        }

        System.out.println();
    }

    public static boolean sortedMatrixSearch(int mat[][], int key){
        int col = 0, row = mat.length - 1;
        while(col < mat[0].length && row >= 0){
            if(mat[row][col] == key){
                System.out.println("Found at: (" + row + ", " + col + ")");
                return true;
            }
            if(key > mat[row][col]){
                col++;
            }
            else{
                row--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        // int mat[][] = new int[3][4];
        // int m = mat.length, n = mat[0].length;
        Scanner sc = new Scanner(System.in);

        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         mat[i][j] = sc.nextInt();
        //     }
        // }
        // System.out.println();

        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(mat[i][j] + " ");
        //     }System.out.println();
        // }
        // System.out.println();
        // spiralPrint(mat);
        
        // // search(mat, 5);
        
        int mat[][] =  {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};
        
        System.out.println(sortedMatrixSearch(mat, sc.nextInt()));
        sc.close();
    }
}
