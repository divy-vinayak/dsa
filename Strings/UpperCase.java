package Strings;

// Convert each word in a given string to uppercase
public class UpperCase {
    public static String toUpperCase(String str){
        StringBuilder str2 = new StringBuilder(Character.toString(Character.toUpperCase(str.charAt(0))));
        for(int i = 1; i < str.length(); i++){
            str2.append(str.charAt(i-1) == ' '? Character.toUpperCase(str.charAt(i)): str.charAt(i));
        }
        return str2.toString();
    }
    public static void main(String[] args) {
        String str = "ho mara, ho mara, HO Mara ....";
        System.out.println(toUpperCase(str));
    }
}
