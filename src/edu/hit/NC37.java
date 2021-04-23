package edu.hit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 合并区间
 *
 * https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=117&tqId=37737&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class NC37 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList<>(0);

        ArrayList<Interval> ret = new ArrayList<>();
        int len = intervals.size();
        // 按区间左边的位置从小到大排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for(int i = 1;i < len;i++){
            // 前一个区间
            Interval front = intervals.get(i - 1);
            // 后一个区间
            Interval back = intervals.get(i);
            // 后一个区间的左边界小于等于前一个区间的右边界，即有重叠
            if(back.start <= front.end){
                // 更新后一个区间的左右边界
                back.start = front.start;
                back.end = back.end > front.end ? back.end : front.end;
            }
            // 没有重叠直接将前一个区间加入到结果集
            else{
                ret.add(front);
            }
        }
        // 加入最后一个区间
        ret.add(intervals.get(intervals.size() - 1));
        return ret;
    }

}
