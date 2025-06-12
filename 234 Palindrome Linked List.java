// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false
 
// Constraints:
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 
// Follow up: Could you do it in O(n) time and O(1) space?


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode ptr = head, front = head.next;
        ptr.next = null;

        while(front != null){
            ListNode temp = front.next;
            front.next = ptr;
            ptr = front;
            front = temp;
        }    
        return ptr;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverse(slow.next);

        while(revHead != null){
            if(revHead.val != head.val)
                return false;

            revHead = revHead.next;
            head = head.next;    
        }
        return true;
    }
}