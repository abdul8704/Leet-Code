// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100

// Example 3:
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25
 
// Constraints:
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// n is an integer.
// Either x is not zero or n > 0.
// -104 <= xn <= 104

class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1.0) return 1.0;
        boolean neg = n < 0;

        long pow = (n < 0) ? (long)(n)*-1: n;

        double ans = power(x, pow);

        return (neg) ? 1/ans: ans;
    }
    private static double power(double x, long n){
        if(n == 1)
            return x;

        double num = power(x, n/2);

        if(n%2 == 0)
            return num * num;
        else
            return x * (num * num);
    }
}