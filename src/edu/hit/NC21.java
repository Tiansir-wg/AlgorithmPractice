package edu.hit;

/**
 * 链表内指定区间翻转
 *
 * https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=117&tqId=37726&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC21 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        // 找到翻转开始位置的前一个节点
        for(int i = 1;i < m;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next, temp;
        // 翻转m, n之间的节点
        for(int j = m;j < n;j++){
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
