package Strings;
public class StringCompare {

    // almost equivalent str1.compareTo(str2);
    public static int isGreater(String a, String b){
        int i = 0;
        if(a.equals(b)) return 0;
        while(i < a.length() && i < b.length()){
            if(a.charAt(i) > b.charAt(i)){
                return 1;
            }else if(a.charAt(i) == b.charAt(i)){
                i++;
            }else return -1;
        }
        return a.length() > b.length()? 1: -1;
    }
    public static void main(String[] args) {
        String a = new String("divy");
        String b = new String("Div");
        System.out.println(isGreater(a, b));
        System.out.println(a.compareTo(b));
        System.out.println(a.compareToIgnoreCase(b));
    }
}
