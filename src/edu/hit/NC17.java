package edu.hit;

/**
 * 最长回文子串
 *
 * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=117&tqId=37789&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC17 {
    public int getLongestPalindrome(String A, int n) {
        if(A== null || n == 0) return 0;
        boolean[][] dp = new boolean[n][n];
        // 记录出现的最大长度
        int maxLen = 1;
        // len + 1表示字串的长度
        for(int len = 0;len < n;len++){
            // 子串的开始位置
            for(int i = 0;i < n - len;i++){
                // 子串的结束位置
                int j = i + len;
                if((A.charAt(i) == A.charAt(j)) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(len + 1 > maxLen) maxLen = len + 1;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        NC17 nc17 = new NC17();
        System.out.println(nc17.getLongestPalindrome("baabccc", 7));
    }
}
