package Stack;
import java.util.*;

public class PushAtBotton {
    public static void pushAtBotton(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushAtBotton(s, data);
        s.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        
        pushAtBotton(s, 0);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        
    }
}
