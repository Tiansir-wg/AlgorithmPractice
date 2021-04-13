package edu.hit;

import java.util.HashMap;

/**
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=117&tqId=37816&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * 找到字符串的最长无重复字符子串
 */
public class NC41 {
    public int maxLength (int[] arr) {
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int start = 0, end = 0;end < arr.length;end++){
            // 存在
            if(map.containsKey(arr[end])){
                start = max(start,map.get(arr[end]) + 1);
            }
            map.put(arr[end], end);
            maxLen = max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    private int max(int a,int b){
        return a > b ? a : b;
    }
}
