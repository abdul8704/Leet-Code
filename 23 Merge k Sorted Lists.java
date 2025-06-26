// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []
 
// Constraints:
// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private static ListNode merge(ListNode list1, ListNode list2){
        ListNode head = new ListNode(-1);
        ListNode ptr = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ptr.next = list1;
                list1 = list1.next;
            }
            else{
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        if(list1 != null)
            ptr.next = list1;
        if(list2 != null)
            ptr.next = list2;

        return head.next;        
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        if(N == 0) return null;

        for(int i= N-1; i > 0; i--){
            ListNode head = merge(lists[i], lists[i-1]);
            lists[i-1] = head;
        }

        return lists[0];
    }
}