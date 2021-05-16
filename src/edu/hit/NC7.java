package edu.hit;

/**
 * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=117&tqId=37717&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * 买卖股票的最佳时机(一次交易)
 */
public class NC7 {
    public int maxProfit (int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for(int i = 1;i < prices.length;i++){
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        NC7 nc7 = new NC7();
        int[] arr = {2,4,3,7};
        System.out.println(nc7.maxProfit(arr));
    }
}
