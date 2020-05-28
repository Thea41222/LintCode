/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode result = new ListNode(-1);
        ListNode tail = result;
        while(l1!=null && l2!=null){
             if(l1.val<=l2.val){
            tail.next = l1;
            l1 = l1.next;
            //System.out.println("l1 is "+l1);
        }else{
            tail.next = l2;
            l2 = l2.next;
            //System.out.println("l2 is " + l2);
        }
            tail=tail.next;
        }
       
        if(l1!=null){
            tail.next = l1;
        }
        if(l2!=null){
            tail.next = l2;
        }
        return result.next;
    }
}