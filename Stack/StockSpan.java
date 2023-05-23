package Stack;

import java.util.*;
// Span is max number of consecutive days for which price <= today's price : index i - index of previous element higher
public class StockSpan{
    public static void getSpan(int stockPrice[], int span[]){
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for(int i = 1; i < stockPrice.length; i++){
            while(!st.isEmpty() && stockPrice[st.peek()] <= stockPrice[i]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }
    }
    public static void main(String[] args) {
        int[] stockPrice = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stockPrice.length];
        getSpan(stockPrice, span);
        for(int i = 0; i < span.length; i++){
            System.out.print(span[i] + " ");
        }System.out.println();
        System.out.print("hello");
    }
    
}