package Stack;
import java.util.*;
public class ValidParentheses {
    public static boolean isABracket(char ch){
        return (ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']');
    }
    public static boolean isAClosingBracket(char ch){
        return (ch == ')' || ch == '}' || ch == ']');
    }
    public static boolean isAnOpeningBracket(char ch){
        return (ch == '(' || ch == '{' || ch == '[');
    }
    public static boolean validParentheses(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(isAnOpeningBracket(str.charAt(i))){
                s.push(str.charAt(i));
            }else if(!s.isEmpty() && isAClosingBracket(str.charAt(i))){
                switch (s.peek()){
                    case '(':
                        if((str.charAt(i) == ')')){
                            s.pop();
                        }else{
                            return false;
                        }
                        break;
                    case '{':
                        if(str.charAt(i) == '}'){
                            s.pop();
                        }else{
                            return false;
                        }
                        break;
                    case '[':
                        if(str.charAt(i) == ']'){
                            s.pop();
                        }else{
                            return false;
                        }
                        break;
                }
            }else if(s.isEmpty() && isAClosingBracket(str.charAt(i))){
                return false;
            }else{
                continue;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String str = "[[]][[[[]]]]";
        System.out.println(validParentheses(str));
    }
}
