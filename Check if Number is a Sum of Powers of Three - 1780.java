// Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
// An integer y is a power of three if there exists an integer x such that y == 3x.

// Example 1:
// Input: n = 12
// Output: true
// Explanation: 12 = 31 + 32

// Example 2:
// Input: n = 91
// Output: true
// Explanation: 91 = 30 + 32 + 34

// Example 3:
// Input: n = 21
// Output: false
 
// Constraints:
// 1 <= n <= 107

class RecursiveSolution {
    public boolean checkPowersOfThree(int n) {
        return helper(0, 1, n);
    }
    private static boolean helper(int currSum, int power, int target){
        if(currSum == target)
            return true;

        if (currSum > target || power > target)  // base conditions
            return false;

        if (helper(currSum + power, power * 3, target)) // include this power in sum
            return true;

        return  helper(currSum, power * 3, target);     // don't include this power in sum
    }
}

class MathSolution {
    public boolean checkPowersOfThree(int n) {      // base 3 representation of number should only have either 1 or 0.
        while (n >= 3){
            if(n % 3 == 2)
                return false;
            n /= 3;    
        }

        return (n != 2);
    }
}