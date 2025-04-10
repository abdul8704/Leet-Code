// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int total = matrix.length * matrix[0].length;

        int up = -1, right = matrix[0].length, down = matrix.length, left = -1;
        int row=0, col=0;

        while(res.size() < total){
            for(col = up+1; col< right; col++){
                res.add(matrix[row][col]);
            }
            up++;
            col--;
            
            for(row =up+1; row<down; row++){
                res.add(matrix[row][col]);
            }
            right--;
            row--;

            if(res.size() == total) break;
            
            for(col=right-1; col>left; col--){
                res.add(matrix[row][col]);
            }
            down--;
            col++;

            for(row=down-1; row>up; row--){
                res.add(matrix[row][col]);
            }
            left++;
            row++;
        }
        return res;
    }
}