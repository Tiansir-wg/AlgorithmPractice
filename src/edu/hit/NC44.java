package edu.hit;

/**
 * 通配符匹配
 *
 * https://www.nowcoder.com/practice/e96f1a44d4e44d9ab6289ee080099322?tpId=117&tqId=37741&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC44 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        // 匹配串为空的情况
        for(int i = 1;i <= pLen;i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int j = 1; j <= pLen;j++){
            for(int i = 1;i <= sLen;i++){
                // 当前位置模式串和匹配串字符相等或者模式串当前字符是'?', 是否匹配取决于前一个位置
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 当前位置不相等且模式串当前字符是'*',取决于匹配串是够存在子串能与模式串*之前的子串匹配
                else if(p.charAt(j - 1) == '*'){
                    // dp[i][j - 1]表示*匹配空串
                    //  dp[i - 1][j - 1]表示*匹配一个字符
                    // dp[i - 1][j]表示*匹配*匹配多个字符
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        NC44 nc44 = new NC44();
        System.out.println(nc44.isMatch("", "*"));
    }
}
