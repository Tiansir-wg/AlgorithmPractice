package edu.hit;

/**
 * 最大正方形
 *
 * https://www.nowcoder.com/practice/0058c4092cec44c2975e38223f10470e?tpId=117&tqId=37832&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC108 {
    public int solve (char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        // dp[i][j]表示以(i,j)位置为右顶点的正方形
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 最大边长
        int maxLen = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1;
                    }
                }
                if(maxLen < dp[i][j]) maxLen = dp[i][j];
            }
        }
        return maxLen * maxLen;
    }
}
