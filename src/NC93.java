import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=117&tqId=37804&rp=1&ru=%2Fta%2Fjob-code-high&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC93 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // LRU缓存
        LinkedHashMap<Integer,Integer> lru = new LinkedHashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int[] ops:operators){
            switch (ops[0]){
                // set
                case 1:{
                    // 缓存未满
                    if(lru.size() < k){
                        lru.put(ops[1],ops[2]);
                    }else{
                        // 缓存已满
                        Iterator iterator = lru.keySet().iterator();
                        lru.remove(iterator.next());
                        lru.put(ops[1],ops[2]);
                    }
                }
                break;
                // get
                case 2:{
                    // key已经存在
                    if(lru.containsKey(ops[1])){
                        int value = lru.get(ops[1]);
                        lru.remove(ops[1]);
                        arrayList.add(value);
                        lru.put(ops[1],value);
                    }
                    // key不存在
                    else{
                        arrayList.add(-1);
                    }
                }
                break;
            }
        }
        int[] ret = new int[arrayList.size()];
        for(int i = 0;i < arrayList.size();i++){
            ret[i] = arrayList.get(i);
        }
        return ret;
    }
}
