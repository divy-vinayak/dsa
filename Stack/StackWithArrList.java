package Stack;

import java.util.ArrayList;

public class StackWithArrList {
    public static class Stack{
        ArrayList<Integer> list;
        int lastIdx;
        public boolean isEmpty(){
            if(list.size() == 0) return true;
            return false;
        }

        Stack(){
            list = new ArrayList<>();
            lastIdx = -1;
        }

        public void push(int data){
            list.add(data);
            lastIdx++;
        }

        public int peek(){
            if(!isEmpty()){
                return list.get(lastIdx);
            }
            return Integer.MIN_VALUE;
        }
        
        public int pop(){
            if(!isEmpty()){
                int val = list.get(lastIdx);
                list.remove(lastIdx);
                lastIdx--;
                return val;
            }
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        while(!s.isEmpty()){
            System.out.print(s.peek() + " " + s.pop() + ", ");
        }System.out.println();
    }
}
