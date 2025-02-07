// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example 1:


// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:

// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200
class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int dp[][] = new int[R][C];
        dp[0][0] = grid[0][0];

        for(int row = 1; row<C; row++){
            dp[0][row] = grid[0][row] + dp[0][row-1];
        }
        for(int col = 1;col<R; col++){
            dp[col][0] = grid[col][0] + dp[col-1][0];
        }

        for(int row = 1; row < R; row++){
            for(int col = 1; col<C; col++){
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }
        return dp[R-1][C-1];
    }
}

