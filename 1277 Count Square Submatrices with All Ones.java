// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

// Example 1:
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.

// Example 2:
// Input: matrix = 
// [
//   [1,0,1],
//   [1,1,0],
//   [1,1,0]
// ]
// Output: 7
// Explanation: 
// There are 6 squares of side 1.  
// There is 1 square of side 2. 
// Total number of squares = 6 + 1 = 7.
 
// Constraints:
// 1 <= arr.length <= 300
// 1 <= arr[0].length <= 300
// 0 <= arr[i][j] <= 1

class Solution {
    public int countSquares(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        int[][] dp = new int[R][C];
        int sum = 0;

        for(int i=0; i<R; i++){
            dp[i][0] = mat[i][0];
            sum += dp[i][0];
        }
            // System.out.println(sum);
            
        
        for(int i=1; i<C; i++){
            dp[0][i] = mat[0][i];
            sum += dp[0][i];
        }
            // System.out.println(sum);

        for(int i=1; i<R; i++){
            for(int j=1; j<C; j++){
                if(mat[i][j] == 0)
                    continue;
                
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                sum += dp[i][j];
            }
            // System.out.println();
        }

        // for(int i=0; i<R; i++){
        //     for(int j=0; j<C; j++){
                
        //         // System.out.print(dp[i][j] + " ");
        //     }
        //     // System.out.println();
        // }

        return sum;
    }
}