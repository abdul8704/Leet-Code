// You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.
// Return any such subsequence as an integer array of length k.
// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [2,1,3,3], k = 2
// Output: [3,3]
// Explanation:
// The subsequence has the largest sum of 3 + 3 = 6.

// Example 2:
// Input: nums = [-1,-2,3,4], k = 3
// Output: [-1,3,4]
// Explanation: 
// The subsequence has the largest sum of -1 + 3 + 4 = 6.

// Example 3:
// Input: nums = [3,4,3,3], k = 2
// Output: [3,4]
// Explanation:
// The subsequence has the largest sum of 3 + 4 = 7. 
// Another possible subsequence is [4, 3].
 
// Constraints:
// 1 <= nums.length <= 1000
// -105 <= nums[i] <= 105
// 1 <= k <= nums.length

import java.util.PriorityQueue;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if(nums.length == k) return nums;
        int[] res = new int[k];
        PriorityQueue<Num> maxHeap = new PriorityQueue<>((a, b) -> b.num - a.num);
        PriorityQueue<Num> minHeap = new PriorityQueue<>((a, b) -> b.ind - a.ind);

        for(int i=0; i<nums.length; i++)
            maxHeap.offer(new Num(nums[i], i));

        for(int i = k-1; i>=0; i--)
            minHeap.offer(maxHeap.poll());
        
        for(int i=k-1; i>=0; i--)
            res[i] = minHeap.poll().num;
        

        return res;

    }
}
class Num{
    int num;
    int ind;
    Num(int x, int y){
        num = x;
        ind = y;
    }
}