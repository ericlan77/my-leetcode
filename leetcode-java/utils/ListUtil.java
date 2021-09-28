package utils;

public class ListUtil {
    public static void printList(ListNode cur){
        while(cur != null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static ListNode buildLinkedList(int[] array){
        ListNode head = new ListNode(0);
        ListNode curr  = head;
        for(int num: array){
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return head.next;
    }
}
