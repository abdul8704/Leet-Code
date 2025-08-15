// Given an integer n, return true if it is a power of four. Otherwise, return false.
// An integer n is a power of four, if there exists an integer x such that n == 4x.

// Example 1:
// Input: n = 16
// Output: true

// Example 2:
// Input: n = 5
// Output: false

// Example 3:
// Input: n = 1
// Output: true
 
// Constraints:
// -231 <= n <= 231 - 1
 
// Follow up: Could you solve it without loops/recursion?

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        int min = 0, max = 15;

        while(min <= max){
            int mid = (min + max) / 2;
            int pow = (int) Math.pow(4, mid);

            if(pow == n)
                return true;
            else if(pow > n)
                max = mid - 1;
            else
                min = mid + 1;    
        }

        return false;
    }
}