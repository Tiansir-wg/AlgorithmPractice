package edu.hit;

/**
 * 最长公共子串
 *
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=117&tqId=37799&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC127 {
    public String LCS (String str1, String str2) {
        int maxLen = 0, endI = -1;
        int str1Len  = str1.length(), str2Len = str2.length();
        // dp[i][j]表示str1中第i个字符之前的部分和str2第j个字符之前的部分的最长公共子串长度
        int[][] dp = new int[str1Len][str2Len];
        int i = 0, j = 0;
        for(i = 0;i < str1Len;i++){
            for(j = 0;j < str2Len;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                if(maxLen < dp[i][j]){
                    maxLen = dp[i][j];
                    endI = i;
                }
            }
        }
        return str1.substring(endI - maxLen + 1, endI + 1);
    }

    public static void main(String[] args) {
        NC127 nc127 = new NC127();
        String str1 = "2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80";
        String str2 = "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2";
        System.out.println(nc127.LCS(str1, str2));
    }
}
