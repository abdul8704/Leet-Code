// Given the head of a linked list, return the list after sorting it in ascending order.

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]

// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Example 3:
// Input: head = []
// Output: []
 
// Constraints:
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private static ListNode middle(ListNode head){
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right){
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;

        while (left != null && right != null){
            if(left.val <= right.val){
                ptr.next = new ListNode(left.val);
                left = left.next;
            }
            else{
                ptr.next = new ListNode(right.val);
                right = right.next;
            }
            ptr = ptr.next;
        }
        while(left != null){
            ptr.next = new ListNode(left.val);
            ptr = ptr.next;
            left = left.next;
        }
        while(right != null){
            ptr.next = new ListNode(right.val);
            ptr = ptr.next;
            right = right.next;  
        }

        return newHead.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode mid = middle(head);
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);

    }
}