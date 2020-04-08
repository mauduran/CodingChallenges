
public class buyStocks {

    public static int maxProfit(int[] prices){
        int profit = 0;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
                if(prices[i]<low){
                    low = prices[i];
                }else{
                    while(i<prices.length && prices[i]>high){
                        high = prices[i];
                        i++;
                    }

                    i--;

                    if(i>=prices.length) break;
                    
                    profit += high - low;

                    low = Integer.MAX_VALUE;
                    high = Integer.MIN_VALUE;
                }
        } 
        return profit;
    }

    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}