// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode last = head;
        ListNode tempPtr = new ListNode();
        int i=1;

        int n=0;
        ListNode temp = head;

        while(temp != null) {
            n++;
            temp = temp.next;
        } 
        
        if (k == n || n == 0 || head == null)  return head;
    
        k %= n;

        if(k == 0){
            return head;
        }

        while(last.next != null){
            if(i == n-k){
                tempPtr = last.next;
                last.next = null;
                last = tempPtr;
            }
            else
                last = last.next;

            i++;    
        }

        last.next = head;

        return tempPtr;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}