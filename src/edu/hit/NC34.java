package edu.hit;

/**
 * 求路径
 *
 * https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358?tpId=117&tqId=37736&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC34 {
    public int uniquePaths (int m, int n) {
        if(m < 1 || n < 1) return 0;
        // dp[i][j]表示从(0,0)位置到(i,j)的走法
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
