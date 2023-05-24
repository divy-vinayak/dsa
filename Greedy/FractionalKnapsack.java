package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int weight[] = {10, 20, 30};
        int val[] = {60, 100, 120};
        int W = 50;
        double valForWeight[][] = new double[weight.length][2];
        for(int i = 0; i < valForWeight.length; i++){
            valForWeight[i][0] = i;
            valForWeight[i][1] = (double)val[i]/weight[i];
        }

        // sorted in ascending order
        Arrays.sort(valForWeight, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalValue = 0;

        for(int i = valForWeight.length - 1; i >= 0; i--){
            if(weight[(int)valForWeight[i][0]] < capacity){
                capacity -= weight[(int)valForWeight[i][0]];
                finalValue += val[(int)valForWeight[i][0]];
            }else{
                finalValue += valForWeight[i][1]*capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("The final worth of contents of sack: " + finalValue);
    }
}
