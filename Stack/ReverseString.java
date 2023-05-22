package Stack;
import java.util.*;
public class ReverseString {
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            s.push(str.charAt(i));
        }
        StringBuilder newStr = new StringBuilder("");
        while(!s.isEmpty()){
            newStr.append(s.pop());
        }
        return newStr.toString();
    }   

    public static void main(String[] args) {
        String s = "bismillah ae rehman ae raheem";
        System.out.println(reverseString(s));
    }
}
