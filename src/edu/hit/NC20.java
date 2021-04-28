package edu.hit;

import java.util.ArrayList;

/**
 * 数字字符串转化IP地址
 *
 * https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=117&tqId=37725&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * 25525522135
 */
public class NC20 {
    public ArrayList<String> restoreIpAddresses (String s) {
        // 注意不能返回null
        if(s == null || s.length() < 4) return new ArrayList<>(0);
        ArrayList<String> ret = new ArrayList<>();
        helper(ret,"",s,0);
        return ret;
    }

    public void helper(ArrayList<String> ret, String sb, String s, int dotCnt){
        // 三个点时前三部分已经验证通过，只需要验证最后一部分符合
        if(dotCnt == 3){
            if(Integer.valueOf(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')) return;
            sb += s;
            ret.add(sb);
            return;
        }
        // 从当前剩余的字符中选择
        for(int i = 1;i < 4 && i < s.length();i++){
            String temp = s.substring(0, i);
            // 验证符合要求
            if(Integer.valueOf(temp) > 255 || (temp.length() > 1 && temp.charAt(0) == '0')) return;
            helper(ret,sb + temp + ".",s.substring(i),dotCnt + 1);
        }
    }

    public static void main(String[] args) {
        NC20 nc20 = new NC20();
        ArrayList<String> ret = nc20.restoreIpAddresses("1111");
        for (String s : ret) {
            System.out.println(s);
        }

    }
}
