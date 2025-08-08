// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Example 1:
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

// Example 2:
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.
 
// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100

class Solution {
    private static int[][] offset = {{-1, -1}, {-1, 0}, {-1, 1}};

    private static  boolean inBound(int row, int col, int R, int C){
        return (col >= 0 && col < C && row >= 0 && row < R);
    }
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++)
            dp[0][i] = matrix[0][i];

        for(int row=1; row<N; row++){
            for(int col=0; col<N; col++){
                int num = matrix[row][col],
                    sum = Integer.MAX_VALUE;

                for(int ctr=0; ctr<offset.length; ctr++){
                    int prevR = row + offset[ctr][0];
                    int prevC = col + offset[ctr][1];

                    if(!inBound(prevR, prevC, N, N))
                        continue;

                    sum = Math.min(sum, dp[prevR][prevC]);
                }

                dp[row][col] = num + sum;
            }
        }    

        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<N; i++)
            min = Math.min(min, dp[N-1][i]);

        return min;    
    }
}