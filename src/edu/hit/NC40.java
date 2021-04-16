package edu.hit;

import java.util.Stack;

/**
 * 链表相加
 *
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=117&tqId=37814&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC40 {

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode temp1 = head1, temp2 = head2;
        // 返回的头结点
        ListNode head = null;

        while(temp1 != null || temp2 != null){
            if(temp1 != null){
                stack1.push(temp1.val);
                temp1 = temp1.next;
            }

            if(temp2 != null){
                stack2.push(temp2.val);
                temp2 = temp2.next;
            }
        }
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int num1 = 0, num2 = 0;
            if(!stack1.isEmpty()){
                num1 = stack1.pop();
            }
            if(!stack2.isEmpty()){
                num2 = stack2.pop();
            }
            int sum = num1 + num2 + carry;
            carry = sum > 9 ? 1 : 0;
            ListNode node = new ListNode(sum > 9 ? sum - 10 : sum);
            if(head == null){
                head = node;
            }else{
                node.next = head;
                head = node;
            }
        }
        return head;
    }
}
