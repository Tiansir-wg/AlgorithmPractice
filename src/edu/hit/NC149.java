package edu.hit;

/**
 * KMP 算法
 *
 * https://www.nowcoder.com/practice/bb1615c381cc4237919d1aa448083bcc?tpId=117&tqId=37859&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC149 {
    public int kmp(String S, String T) {
        if (T == null || T.length() == 0) return 0;
        // S是模式串, T是匹配串
        int sLen = S.length();
        int tLen = T.length();
        // 初始化next数组
        int[] next = getNext(S);
        // 匹配个数
        int cnt = 0;
        int sIndex = 0, tIndex = 0;
        while (tIndex < tLen && sIndex < sLen) {
            // 当前字符相等, 继续匹配下一个
            if (sIndex == -1 || S.charAt(sIndex) == T.charAt(tIndex)) {
                tIndex++;
                sIndex++;
                // 找到一个完整的匹配, 模式串跳转到next位置, 匹配串位置不变
                if(sLen == sIndex){
                    cnt++;
                    sIndex = next[sIndex - 1];
                    // 因为前面自增过所以需要还原
                    tIndex--;
                }
            }
            // 模式串跳转到next位置
            else {
                sIndex = next[sIndex];
            }
        }
        return cnt;
    }

    private int[] getNext(String Pattern) {
        // next[i]表示模式串[0 ~ i]的最长公共前后缀的长度
        if(Pattern == null || Pattern.length() == 0) return new int[0];
        int len = Pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = -1;
        for(int j = 1;j < len;j++){
            // 当前串
            while(i != -1 && Pattern.charAt(j) != Pattern.charAt(i + 1)){
                i = next[i];
            }
            if(Pattern.charAt(i + 1) == Pattern.charAt(j)){
                i++;
            }
            next[j] = i;
        }
        return next;
    }

    public static void main(String[] args) {
        NC149 nc149 = new NC149();
        String Pattern = "ababab", Text = "abababab";
        System.out.println(nc149.kmp(Pattern, Text));
    }
}
