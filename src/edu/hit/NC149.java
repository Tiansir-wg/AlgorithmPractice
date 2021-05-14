package edu.hit;

import java.util.regex.Pattern;

public class NC149 {
    public int kmp(String S, String T) {
        if (T == null || T.length() == 0) return 0;
        int sLen = S.length();
        int tLen = T.length();
        int[] next = new int[sLen];
        getNext(S, next);
        int cnt = 0;
        int sIndex = 0, tIndex = 0;
        while (tIndex < tLen && sIndex < sLen) {
            if (sIndex == -1 || S.charAt(sIndex) == T.charAt(tIndex)) {
                tIndex++;
                sIndex++;
                if(sLen == sIndex){
                    cnt++;
                    sIndex = next[sIndex - 1];
                }
            } else {
                sIndex = next[sIndex];
            }
        }
        return cnt;
    }

    private void getNext(String Pattern ,int[] next) {
        // next[i]表示模式串[0 ~ i]的最长公共前后缀的长度
        next[0] = -1;
        int i = -1;
        for(int j = 1;j < Pattern.length();j++){
            // 当前串
            while(i != -1 && Pattern.charAt(j) != Pattern.charAt(i + 1)){
                i = next[i];
            }
            if(Pattern.charAt(i + 1) == Pattern.charAt(j)){
                i++;
            }
            next[j] = i;
        }
    }

    public static void main(String[] args) {
        NC149 nc149 = new NC149();
        String Pattern = "ababab", Text = "abababab";
        System.out.println(nc149.kmp(Pattern, Text));
    }
}
