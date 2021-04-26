package edu.hit;

/**
 * 链表的奇偶重排
 *
 * https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=117&tqId=37845&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC133 {
    public ListNode oddEvenList (ListNode head) {
        if(head == null || head.next == null) return head;
        // 分别表示偶数链表的头结点,奇数链表的当前节点和偶数链表的当前节点
        ListNode evenHead = head.next, oddCur = head, evenCur = evenHead;
        while(evenCur != null && evenCur.next != null){
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
