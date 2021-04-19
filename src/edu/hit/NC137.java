package edu.hit;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4?tpId=117&tqId=37849&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * 表达式求值
 */
public class NC137 {

    public int solve (String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        // 运算符栈
        Stack<Character> operator = new Stack<>();
        // 操作数栈
        Stack<Integer> operand = new Stack<>();
        // 操作符优先级
        HashMap<Character,Integer> priority = new HashMap<>();
        priority.put('+',0);
        priority.put('-',0);
        priority.put('*',1);

        for(int i = 0; i < len;i++){
            char ch = s.charAt(i);
            // 操作数
            if(ch >= '0' && ch <= '9'){
                StringBuilder sb = new StringBuilder();
                while(i < len && (ch = s.charAt(i)) <= '9' && ch >= '0'){
                    sb.append(ch);
                    i++;
                }
                operand.push(resolveInt(sb,0,sb.length() - 1));
                i--;
            }
            // 运算符
            else{
                // 运算符栈不空则与栈顶运算符比较优先级
                if(!operator.isEmpty()){
                    char topOperator = operator.peek();
                    if(priority.get(topOperator) >= priority.get(ch)){
                        while(priority.get(topOperator) >= priority.get(ch) && !operator.isEmpty()){
                            int num1 = operand.pop();
                            int num2 = operand.pop();
                            char ope = operator.pop();
                            if(ope == '+'){
                                operand.push(num1 + num2);
                            }else if(ope == '-'){
                                operand.push(num1 - num2);
                            }else if(ope == '*'){
                                operand.push(num1 * num2);
                            }
                            topOperator = operator.peek();
                            i++;
                            ch = s.charAt(i);
                        }
                        i--;
                    }else if(priority.get(topOperator) < priority.get(ch)){
                        operator.push(ch);
                    }
                }
                // 否则直接入栈
                else{
                    operator.push(ch);
                }
            }
        }

        int num1 = operand.pop();
        int num2 = operand.pop();
        char ope = operator.pop();
        if(ope == '+'){
            operand.push(num1 + num2);
        }else if(ope == '-'){
            operand.push(num1 - num2);
        }else if(ope == '*'){
            operand.push(num1 * num2);
        }

        return operand.pop();
    }

    private int resolveInt(StringBuilder s,int start,int end){
        int num = 0;
        for(int i = start;i <= end;i++){
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        NC137 nc = new NC137();
        System.out.println(nc.solve("1+2+23"));
    }
}
