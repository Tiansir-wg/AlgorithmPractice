package edu.hit;

/**
 * 矩阵的最小路径和
 *
 * https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=117&tqId=37823&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC59 {
    public int minPathSum (int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]表示从matrix[0][0]走到matrix[i][j]位置的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        // 第一行元素只能从左往右
        for(int j = 1;j < n;j ++){
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 第一列
        for(int i = 1;i < m;i ++){
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for(int i = 1;i < m;i ++){
            for(int j = 1;j < n;j++){
                dp[i][j] = min(dp[i - 1][j],dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    private int min(int a,int b){
        return a > b ? b : a;
    }
}
