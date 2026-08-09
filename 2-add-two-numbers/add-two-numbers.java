/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode currNode = new ListNode();
        ListNode ans = currNode;
        while(l1 != null || l2!= null){
            int l1val = l1==null?0:l1.val;
            int l2val = l2==null?0:l2.val;
            int currvalue = l1val + l2val + carry;
            int value = currvalue%10;
            carry = currvalue/10;
            currNode.val = value;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
            if(l1 !=null || l2 != null || carry!=0 ){
                ListNode newNode = new ListNode();
                currNode.next = newNode;
                currNode = newNode;
            }
        }
        if(carry != 0) currNode.val = carry;
        return ans;
    }
}