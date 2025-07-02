// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

// Example 1:
// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

// Example 2:
// Input: n = 4
// Output: 400

// Example 3:
// Input: n = 50
// Output: 564908303
 
// Constraints:
// 1 <= n <= 1015

class Solution {
    public int countGoodNumbers(long N) {
        int MOD = 1000000007;
        
        long even_count = (N%2 == 1)?(N/2)+1: N/2;
        long odd_count = N/2;

        long odd = power(4, odd_count, MOD) % MOD;
        long even = power(5, even_count, MOD) % MOD;

        return (int)((odd * even) % MOD);
    }
    private static long power(long base, long power, int MOD){
        if(power == 0)
            return (long)1;

        if(power%2 == 0){
            long ans = power(base, power/2, MOD);
            return (ans * ans) % MOD;
        }    
        else{
            long ans = power(base, power/2, MOD);
            return (base*(ans * ans)) % MOD ;
        }
    }
}