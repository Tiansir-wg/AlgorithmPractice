package edu.hit;

import java.util.ArrayList;

/**
 * 括号生成
 *
 * https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=117&tqId=37748&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC26 {
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> ret = new ArrayList<>();
        helper(ret, new StringBuilder(), 0 , 0, n);
        return ret;
    }

    private void helper(ArrayList<String> ret, StringBuilder sb, int openBrace, int closeBrace, int n){
        if(sb.length() == n + n){
            ret.add(sb.toString());
            return;
        }
        if(openBrace < n){
            sb.append('(');
            helper(ret, sb, openBrace + 1, closeBrace, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closeBrace < openBrace){
            sb.append(')');
            helper(ret, sb, openBrace, closeBrace + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
