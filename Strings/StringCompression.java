package Strings;

public class StringCompression {
    // check again
    public static String compressString(String str){
        StringBuilder str2 = new StringBuilder("");
        Integer count = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            while(i < str.length() && str.charAt(i) == ch){
                count++;
                i++;
                System.out.println(ch + ": " + count);
            }
            str2.append(ch);
            str2.append(count > 1? count.toString(): "");
            count = 0;
        }
        return str2.toString();
    }
    public static void main(String[] args) {
        String str = "aabbbbxxdssgggg";
        System.out.println(compressString(str));
    }
}
