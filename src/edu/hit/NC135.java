package edu.hit;

/**
 * 股票交易的最大利润2
 *
 * https://www.nowcoder.com/practice/4892d3ff304a4880b7a89ba01f48daf9?tpId=117&tqId=37847&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
 */
public class NC135 {
    public int maxProfit (int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        // buy1表示一天结束时只进行了一次买入
        // sell1表示一天结束时只进行了一次买入和一次卖出
        // buy2表示一天结束时完成了一笔交易，进行了第二次买入
        // sell2表示一天结束时完成了两笔交易
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for(int i = 1;i < prices.length;i++){
            // 在前一天的基础上什么都不做或者在没有任何操作的情况下进行一次买入
            buy1 = Math.max(buy1,-prices[i]);
            // 在前一天的基础上什么都不做或者在有一次买入的情况下进行一次卖出
            sell1 = Math.max(buy1 + prices[i], sell1);
            // 在前一天的基础上什么都不做或者在完成一次交易的情况下再进行一次买入
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 在前一天的基础上什么都不做或者在进入第二次买入的情况下进行一次卖出
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        NC135 nc135 = new NC135();
        int[] arr = {8,9,3,5,1,3};
        System.out.println(nc135.maxProfit(arr));
    }
}
