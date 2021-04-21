package edu.hit;

import java.util.Stack;

/**
 * 括号匹配
 *
 * https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=117&tqId=37749&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC52 {
    public boolean isValid (String s) {
        if(s == null || s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            char topChar = stack.peek();
            if((topChar == '(' && ch == ')') || (topChar == '[' && ch == ']') || (topChar == '{' && ch == '}')){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
