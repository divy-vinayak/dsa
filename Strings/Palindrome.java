package Strings;
public class Palindrome {
    public static boolean isPalindrome(String str){
        int left_idx = 0, right_idx = str.length()-1;
        while(left_idx <= right_idx){
            if(str.charAt(left_idx++) != str.charAt(right_idx--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(str + (isPalindrome(str) ? " is a ": " is not a ") + "palindrome");
    }
}
