package Strings;
public class ShortestPath {
    public static double shortestPath(String str){
        int e = 0, w = 0, n = 0, s = 0;
        for(int i = 0; i < str.length(); i++){
            switch(str.charAt(i)){
                case 'e':
                    e++;
                    break;
                case 'w':
                    w++;
                    break;
                case 'n':
                    n++;
                    break;
                case 's':
                    s++;
                    break;
                default:
                    break;
            }
        }

        return Math.sqrt(Math.pow(e-w, 2) + Math.pow(n-s, 2));
    }
    public static void main(String[] args) {
        String route = "wneenesennn";
        System.out.println(shortestPath(route));
    }
}
