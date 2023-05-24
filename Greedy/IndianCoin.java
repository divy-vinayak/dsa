package Greedy;
import java.util.Arrays;
import java.util.Collections;
// minimun number of denominations used to make a value V
public class IndianCoin {
    public static void main(String[] args) {
        Integer currencyNote[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int V = 1059;
        Arrays.sort(currencyNote, Collections.reverseOrder());
        int freq[] = new int[currencyNote.length];
        for(int i = 0; i < freq.length; i++){
            freq[i] = 0;
        }
        int count = 0;
        int val = V;
        for(int i = 0; i < currencyNote.length; i++){
            while(val >= currencyNote[i]){
                val -= currencyNote[i];
                count++;
                freq[i]++;
            }
        }
        System.out.println("The number of currency notes used = " + count);
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                System.out.println(currencyNote[i] + ": x" + freq[i]);
            }
        }
    }
}
