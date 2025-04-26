// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

 
// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
 
// Constraints:
// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles);
        int res = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left+right) / 2;

            if(helper(piles, mid, h)){
                res = Math.min(res, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }
    private static int max(int []arr){
        int m = arr[0];
        for(int i=1; i<arr.length; i++)
            m = Math.max(m, arr[i]);

        return m;
    }
    private static boolean helper(int []arr, int speed, int limit){
        long time = 0;

        for(int pile: arr)
            time += (pile + speed -1)  / speed;
        
        return time <= limit;
    }       
}   