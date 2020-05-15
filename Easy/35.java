public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next=prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}