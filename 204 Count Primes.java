// Given an integer n, return the number of prime numbers that are strictly less than n.

// Example 1:
// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

// Example 2:
// Input: n = 0
// Output: 0

// Example 3:
// Input: n = 1
// Output: 0
 
// Constraints:
// 0 <= n <= 5 * 106

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n+1];
        int count = 0;

        for(int i=2; i<n; i++){
            if(!notPrime[i]){
                count++;
                for(int prime=i; prime<n; prime += i)
                    notPrime[prime] = true;
            }
        }

        return count;
    }
}