package edu.hit;

import java.util.HashMap;

/**
 * 两数之和
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&tqId=37756&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC61 {
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int len = numbers.length;
        for(int i = 0;i < len;i++){
            if(map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]), i + 1};
            }else{
                map.put(numbers[i], i + 1);
            }
        }
        return new int[0];
    }
}
