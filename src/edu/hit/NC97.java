package edu.hit;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 字符串出现次数的TopK问题
 *
 * https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=117&tqId=37809&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC97 {
    class Pair{
        String key;
        Integer cnt;

        public Pair(String key, Integer cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }
    public String[][] topKstrings (String[] strings, int k) {
        if(strings == null || strings.length == 0 || k == 0) return new String[0][0];

        // 记录每个key出现的频次
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : strings){
            map.put(str, map.getOrDefault(str, 0 ) + 1);
        }

        // 构建大顶堆
        PriorityQueue<Pair> bigHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.cnt < o2.cnt){
                    return 1;
                }else if(o1.cnt.compareTo(o2.cnt) == 0 && o1.key.compareTo(o2.key) > 0){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        // 入堆
        for(String key : map.keySet()){
            bigHeap.add(new Pair(key,map.get(key)));
        }

        // 找出前k个
        int cnt = 0;
        String[][] ret = new String[k][2];
        while(cnt < k && !bigHeap.isEmpty()){
            Pair pair = bigHeap.poll();
            ret[cnt][0] = pair.key;
            ret[cnt++][1] = String.valueOf(pair.cnt);
        }
        return ret;
    }

    public static void main(String[] args) {
        NC97 nc97 = new NC97();
        String[] str = {"a","b","c","b"};
        nc97.topKstrings(str, 2);
    }
}
