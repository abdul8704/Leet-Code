// You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:

// Choose the pile with the maximum number of gifts.
// If there is more than one pile with the maximum number of gifts, choose any.
// Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
// Return the number of gifts remaining after k seconds.

 

// Example 1:

// Input: gifts = [25,64,9,4,100], k = 4
// Output: 29
// Explanation: 
// The gifts are taken in the following way:
// - In the first second, the last pile is chosen and 10 gifts are left behind.
// - Then the second pile is chosen and 8 gifts are left behind.
// - After that the first pile is chosen and 5 gifts are left behind.
// - Finally, the last pile is chosen again and 3 gifts are left behind.
// The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
// Example 2:

// Input: gifts = [1,1,1,1], k = 4
// Output: 4
// Explanation: 
// In this case, regardless which pile you choose, you have to leave behind 1 gift in each pile. 
// That is, you can't take any pile with you. 
// So, the total gifts remaining are 4.
 

// Constraints:

// 1 <= gifts.length <= 103
// 1 <= gifts[i] <= 109
// 1 <= k <= 103

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k){

        for(int i = 0; i<k ; i++){
            int pos = max(gifts);
            gifts[pos] =(int) sqrt(gifts[pos]);
        }

        long sum = 0;

        for(int num:gifts){
            sum += num;
        }
        return sum;
    }
    private static int max(int[] arr){
        long m = arr[0];
        int idx = 0;
        for(int i = 1;i < arr.length; i++){
            if(arr[i] > m){
                m = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    private static long sqrt(int n){
        long left = 0, right = n;
        long ans = 0;

        while(left <= right){
            long mid = left + (right- left) / 2;
            if(mid * mid == n){
                return mid;
            }
            else if(mid * mid < n){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

class OptimisedSolution {   //use maxHeap
    public long pickGifts(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            maxHeap.offer(num);
        }

        for(int i=0; i<k; i++){
            int max = maxHeap.poll();
            maxHeap.offer((int) Math.floor(Math.sqrt(max)));
        }
        long res = 0;
        while(!maxHeap.isEmpty()){
            res += maxHeap.poll();      //find sum
        }

        return res;
    }
}

class MoreOptimisedSolution { 
    public long pickGifts(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        long total = 0;

        for(int num: nums){
            maxHeap.offer(num);
            total += num;       // compute total sum
        }

        for(int i=0; i<k; i++){
            int max = maxHeap.poll();
            int reduced = (int) Math.sqrt(max);
            total -= (max - reduced);   //reduce total by how much the value decreases. we skip the need for a O(n) loop
            maxHeap.offer(reduced);
        }
        return total;
    }
}