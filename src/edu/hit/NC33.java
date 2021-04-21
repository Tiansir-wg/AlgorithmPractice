package edu.hit;

/**
 * 合并有序链表
 * https://www.nowcoder.com/practice/a479a3f0c4554867b35356e0d57cf03d?tpId=117&tqId=37735&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * */
public class NC33 {

    class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null, tail = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(head == null){
                    head = l1;
                    tail = l1;
                }else{
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
            }else{
                if(head == null){
                    head = l2;
                    tail = l2;
                }else{
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }

        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }
        return head;
    }
}
