package edu.hit;

/**
 * 字符串转化为整数
 *
 * https://www.nowcoder.com/practice/44d8c152c38f43a1b10e168018dcc13f?tpId=117&tqId=37754&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC100 {
    public int atoi (String str) {
        // 输入为空的情况
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        // 默认为正数
        boolean flag = true;
        // 结果
        long res = 0;
        for(int i = 0;i < str.length();i++){
            if(i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                if(str.charAt(i) == '-') flag = false;
                continue;
            }
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                res = res * 10 + (str.charAt(i) - '0');
            }else{
                break;
            }
        }
        res = flag ? res : -res;
        // 溢出处理
        if(res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }

    public static void main(String[] args) {
        NC100 nc100=  new NC100();
        System.out.println(nc100.atoi("1"));
    }
}
