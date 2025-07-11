// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]
 
// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 
// Follow up: Could you do this in one pass?

//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class OtherSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1)
            return null;

        if(n == 1){
            ListNode ptr = head;
            while(ptr.next.next != null){
                ptr = ptr.next;
            }
            ptr.next = null;
            return head;

        }
        ListNode ptr = head, fast = head;
        for(int i=1; i<=n; i++)
            fast = fast.next;
        
        while(fast != null){
            ptr = ptr.next;
            fast = fast.next;
        }

        ptr.val = ptr.next.val;
        ptr.next = ptr.next.next;

        return head;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        for(int i=0; i<=n; i++)
            fast = fast.next;

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }    

        slow.next = slow.next.next;
        return dummy.next;
    }
}