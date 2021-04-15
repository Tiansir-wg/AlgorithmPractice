package edu.hit;

/**
 * 大数加法
 *
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=117&tqId=37842&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC1 {
    public String solve (String s, String t) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1;
        int sum = 0;
        int shift = 0;
        while(i >= 0 && j >= 0){
            sum = (s.charAt(i) - '0') + (t.charAt(j) - '0') + shift;
            if(sum >= 10){
                shift = 1;
                sb.append(sum - 10);
            }else{
                sb.append(sum);
                shift = 0;
            }
            i--;
            j--;
        }
        while(i >= 0){
            sum = (s.charAt(i) - '0') + shift;
            if(sum >= 10){
                shift = 1;
                sb.append(sum - 10);
            }else{
                sb.append(sum);
                shift = 0;
            }
            i--;
        }
        while(j >= 0){
            sum = (t.charAt(j) - '0') + shift;
            if(sum >= 10){
                shift = 1;
                sb.append(sum - 10);
            }else{
                sb.append(sum);
                shift = 0;
            }
            j--;
        }
        if(shift > 0){
            sb.append(shift);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        NC1 nc1 = new NC1();
        System.out.println(nc1.solve("1", "99"));
    }
}
