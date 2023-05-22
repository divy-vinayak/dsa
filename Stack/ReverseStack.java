package Stack;
import java.util.*;
public class ReverseStack {
    public static void pushAtBotton(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushAtBotton(s, data);
        s.push(temp);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()) return;

        int val = s.pop();
        reverseStack(s);
        pushAtBotton(s, val);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        reverseStack(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
