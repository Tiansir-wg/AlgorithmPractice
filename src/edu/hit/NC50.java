package edu.hit;

/**
 * 链表中的节点每k个一组翻转
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=117&tqId=37746&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */

public class NC50 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        // 长度
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len ++;
            temp = temp.next;
        }
        if(len < k) return head;
        ListNode dummy = new ListNode(0), pre = dummy, cur = head, next;
        dummy.next = head;
        // 长度为K的子链的数量
        int groups = len / k;
        for(int i = 0;i < groups;i++){
            // 翻转子链
            for(int j = 1;j < k;j++){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
