public class Stock {
    public static void maxProfit(int prices[]){
        int minTillNow = prices[0];
        int maxPro = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            int curPro = prices[i] - minTillNow;
            if(curPro > maxPro) maxPro = curPro;
            if(prices[i] < minTillNow) minTillNow = prices[i];
        }
        System.out.println("Max Profit will be: " + maxPro);
    }
    public static void main(String[] args) {
        // int prices[] = {7,1,5,3,6,4};
        int prices[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        maxProfit(prices);
    }
}
