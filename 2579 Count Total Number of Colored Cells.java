// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.
// Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.

// Return the number of colored cells at the end of n minutes.

// Example 1:
// Input: n = 1
// Output: 1
// Explanation: After 1 minute, there is only 1 blue cell, so we return 1.

// Example 2:
// Input: n = 2
// Output: 5
// Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5. 
 
// Constraints:
// 1 <= n <= 105

class Solution1 {      // generate the formula
    public long coloredCells(int n) {
        return 1 + (long)n * (n-1) * 2 ; 
    }
}
class Solution2 {      // generate the formula
    public long coloredCells(int n) {
        long nSquare = (long)n * n;
        long nMinusOneSquare = (long) (n - 1) * (n - 1);

        // Return sum while ensuring it's within long limits
        return nSquare + nMinusOneSquare;
    }
}
class Solution3 {      // generate the formula
    public long coloredCells(int n) {
        return ((long)n * n) + ((long) (n - 1) * (n - 1));
    }
}

class BruteForceSolution {      // generate the sequence
    public long coloredCells(int n) {
        long[] nums = new long[n+1];
        nums[0] = 1;

        for(int i=1; i<n; i++){
            nums[i] = nums[i-1] + (4*i);
        }
        return nums[n-1];
    }
}