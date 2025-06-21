// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1;
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
 
// Constraints:
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
 
// Follow-up: Can you solve the problem in O(1) extra memory space?
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    private static ListNode[] reverse(ListNode head){
        if(head == null || head.next == null)   
            return new ListNode[]{head, head};

        ListNode ptr = head.next, ret = head;
        head.next = null;
        while(ptr.next != null){
            ListNode front = ptr.next;
            ptr.next = head;
            head = ptr;
            ptr = front;
        }    
        ptr.next = head;
        return new ListNode[]{ptr, ret};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;

        ListNode start = head, ptr = head, dummy = new ListNode(-1);
        ListNode ret = head;
        boolean first  = true;
        int c = 0;

        while(ptr != null){
            c++;
            if(c == k){
                ListNode front = ptr.next;
                ptr.next = null;

                ListNode[] nodes = reverse(start);
                ListNode revHead = nodes[0], revTail = nodes[1];

                if(first){
                    ret = revHead;
                    first = false;
                }
                else{
                    dummy.next = revHead;
                }

                dummy = revTail;
                revTail.next = front;

                ptr = front;
                start = front;
                c = 0;
            }
            else
                ptr = ptr.next;
        }

        return ret;

    }
}