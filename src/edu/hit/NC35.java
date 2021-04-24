package edu.hit;

/**
 * 最小编辑距离
 *
 * https://www.nowcoder.com/practice/05fed41805ae4394ab6607d0d745c8e4?tpId=117&tqId=37801&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC35 {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        if(str1 == null && str2 == null) return 0;
        if(str1 == null) return str2.length() * ic;
        if(str2 == null) return str1.length() * rc;
        int len1 = str1.length(), len2 = str2.length();
        // dp[i][j]表示str1的前i个字符转化为str2的前j个字符的最小代价
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1;i <= len1;i++){
            dp[i][0] = dc * i;
        }

        for(int j = 1;j <= len2;j++){
            dp[0][j] = ic * j;
        }
        for(int i = 1;i <= len1;i++){
            char ch1 = str1.charAt(i - 1);
            for(int j = 1;j <= len2;j++){
                char ch2 = str2.charAt(j - 1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int insertCost = dp[i][j - 1] + ic;
                    int replaceCost = dp[i - 1][j - 1] + rc;
                    int deleteCost = dp[i - 1][j] + dc;
                    dp[i][j] = minCost(insertCost, minCost(replaceCost, deleteCost));
                }
            }
        }
        return dp[len1][len2];
    }
    private int minCost(int a,int b){
        return a < b ? a : b;
    }
}
