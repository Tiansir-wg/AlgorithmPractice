package edu.hit;

/**
 * 最长公共子序列
 *
 * https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11?tpId=117&tqId=37798&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC92 {
    public String LCS (String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return "-1";
        int rows = s1.length();
        int cols = s2.length();
        // dp[i][j]表示s1的前i个字符和s2的前j个字符的最长公共子序列
        int[][] dp = new int[rows + 1][cols + 1];
        // 填充DP数组，寻找最大长度
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = rows, j = cols;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }

    public static void main(String[] args) {
        NC92 nc92 = new NC92();
        System.out.println(nc92.LCS("1A2C3D4B56", "B1D23CA45B6A"));
    }
}
