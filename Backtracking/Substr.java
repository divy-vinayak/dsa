package Backtracking;

public class Substr{

    // Time complexity O(n*2^n), Space complexity O(n)
    public static void allSubStr(String s, String ans, int si){
        if(si == s.length()){
            System.out.println(ans);
            return;
        }

        allSubStr(s, ans+s.charAt(si), si+1);
        allSubStr(s, ans, si+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        allSubStr(str, "", 0);
    }
}