// Given an m x n integers matrix, return the length of the longest increasing path in matrix.

// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

// Example 1:


// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
// Example 2:


// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// Example 3:

// Input: matrix = [[1]]
// Output: 1
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1


class Solution {
    private static int[][] offset = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static boolean check(int i, int j, int R, int C){
        return (i >= 0 && i < R && j >= 0 && j < C);
    }

    private static int dfs(int[][] matrix, int[][] dp, int row, int col, int R, int C){
        if(dp[row][col] != 0)
            return dp[row][col];

        int longest = 0;
        for(int i=0; i<4; i++){ //check 4 neighnors
            int nextR = offset[i][0] + row;
            int nextC = offset[i][1] + col;

            if(!check(nextR, nextC, R, C))
                continue;

            if(matrix[nextR][nextC] > matrix[row][col]){
                int adjPath = dfs(matrix, dp, nextR, nextC, R, C);
                longest = Math.max(adjPath, longest);
            }    
        }    

        dp[row][col] = longest + 1;
        return dp[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int dp[][] = new int[R][C];

        int path = 0, longest = 0;

        for(int row=0; row<R; row++){
            for(int col=0; col < C; col++){
                if(dp[row][col] == 0){
                    path = dfs(matrix, dp, row, col, R, C);
                    int dop = Math.max(path, dp[row][col]);
                    longest = Math.max(dop, longest);
                }
            }
        }

        return longest;
    }
}