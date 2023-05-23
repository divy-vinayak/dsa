package Stack;
import java.util.*;
// For a given balanced expression, find if it contains duplicate parentheses
public class DuplicateParentheses {
    public static boolean containsDuplicateParentheses(String str){
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i < str.length()){
            char curr = str.charAt(i);
            if(curr != ')'){
                s.push(curr);
            } else{
                int count = 0;
                while(s.peek() != '('){
                    count++;
                    s.pop();
                }
                if(count < 1){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(((c)+(d))))";
        System.out.println(containsDuplicateParentheses(str));
    }
}
