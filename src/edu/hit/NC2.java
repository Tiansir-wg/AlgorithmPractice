package edu.hit;


/**
 * 重排链表
 *
 * https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=117&tqId=37712&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        // 快慢指针找中点
        ListNode fast = head, slow = head;
        // 后面一条链表的头结点
        ListNode otherHead = null;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 分割成两条链表
        otherHead = slow.next;
        slow.next = null;

        // 翻转第二条链表
        ListNode cur = otherHead.next;
        otherHead.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = otherHead;
            otherHead = cur;
            cur = next;
        }

        // 合并链表
        // 第一条链表的当前节点
        cur = head;
        while(otherHead != null){
            // 第二条链表当前节点的后一个节点
            ListNode otherTemp = otherHead.next;
            otherHead.next = cur.next;
            cur.next = otherHead;
            cur = otherHead.next;
            otherHead = otherTemp;
        }
    }
}
