// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.


// Example 1:
// Input: n = 1
// Output: true
// Explanation: 20 = 1

// Example 2:
// Input: n = 16
// Output: true
// Explanation: 24 = 16

// Example 3:
// Input: n = 3
// Output: false
 
// Constraints:
// -231 <= n <= 231 - 1
 
// Follow up: Could you solve it without loops/recursion?


class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n&(n-1)) == 0 && n > 0);
    }
}

class Solution2 {
    public boolean isPowerOfTwo(int n) {
        int setBit = 0;
        if(n < 0) return false;

        while(n !=0){
            if((n & 1 )== 1)
                setBit++;
            n >>= 1;    
        }
        return setBit == 1;
    }
}