package Graphs;

public class FloodFill {
    public static void printImg(int[][] img){
        System.out.println("+-----------------+");
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[i].length; j++){
                System.out.print(img[i][j] + " ");
            }System.out.println();
        }
        System.out.println("+-----------------+");
    }

    public static void floodFillHelp(int[][] img, int sr, int sc,int initialColor, int finalCol){
        if(sr < 0 || sc < 0 || sr > img.length-1 || sc > img[0].length-1){
            return;
        }
        if(img[sr][sc] == initialColor){
            img[sr][sc] = finalCol;
            floodFillHelp(img, sr-1, sc, initialColor, finalCol);
            floodFillHelp(img, sr+1, sc, initialColor, finalCol);
            floodFillHelp(img, sr, sc-1, initialColor, finalCol);
            floodFillHelp(img, sr, sc+1, initialColor, finalCol);
        }
    }

    public static void floodFill(int[][] img, int sr, int sc, int finalCol){
        floodFillHelp(img, sr, sc, img[sr][sc], finalCol);
    }
    public static void main(String[] args) {
        int img[][] = new int[10][10];
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[i].length; j++){
                if(i >= 2 && i <= 7 && j >= 2 && j <= 7){
                    img[i][j] = 0;
                }else{
                    img[i][j] = 1;
                }
            }
        }
        
        printImg(img);
        floodFill(img, 5, 5, 9);
        floodFill(img, 0, 0, 0);
        floodFill(img, 5, 5, 1);
        printImg(img);
    }
}
