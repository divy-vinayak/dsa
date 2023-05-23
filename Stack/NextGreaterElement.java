package Stack;
import java.util.*;
public class NextGreaterElement {
    // Time complexity: O(n)
    public static void fillNextGreater(int arr[], int nextGreater[]){
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                nextGreater[i] = arr[s.peek()];
            }else{
                nextGreater[i] = -1;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[arr.length];
        fillNextGreater(arr, nextGreater);
        for(int i = 0; i < nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }System.out.println();
    }
}
